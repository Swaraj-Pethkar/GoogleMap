package com.example.googlemap.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.googlemap.R
import com.example.googlemap.databinding.ActivityEditBinding
import kotlinx.android.synthetic.main.activity_edit.*

class Edit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle : Bundle? = intent.extras

        val id:Int = bundle!!.getInt("id")
        val name = bundle!!.getString("name")
        val email = bundle!!.getString("email")
        val phoneNumber = bundle!!.getString("phoneNumber")
        val address = bundle!!.getString("address")
        val latitude = bundle!!.getString("latitude")
        val longitude = bundle!!.getString("longitude")
        val toLatitude = bundle!!.getString("toLatitude")
        val toLongitude = bundle!!.getString("toLongitude")

        val updateData = Users(name,email,phoneNumber,address,latitude,longitude,toLatitude,toLongitude)


        var mUserViewModel: UserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.updateData = updateData
        btnUpdate.setOnClickListener{
            if(inputCheck(updateName.text.toString(), updateEmail.text.toString(), updatePhoneNumber.text.toString(), updateAddress.text.toString(), updateLatitude.text.toString(), updateLongitude.text.toString(), updateToLatitude.text.toString(), updateToLongitude.text.toString())){
                val upUser = User(id,updateName.text.toString(),updateEmail.text.toString(),updatePhoneNumber.text.toString(),updateAddress.text.toString(),updateLatitude.text.toString(),updateLongitude.text.toString(),updateToLatitude.text.toString(),updateToLongitude.text.toString())

                mUserViewModel.updateUser(upUser)
                toast("Data Updated Successfully")
                finish()
            }
            else{
                toast("All Fields Mandatory")
            }
        }

        btnDelete.setOnClickListener{

            val delUser = User(id,name.toString(),email.toString(),phoneNumber.toString(),address.toString(),latitude.toString(),longitude.toString(),toLatitude.toString(),toLongitude.toString())

            mUserViewModel.deleteUser(delUser)
            toast("Data Deleted Successfully")
            finish()
        }

        btnMap.setOnClickListener{
            val intent = Intent(this,MapDynamic::class.java)
            intent.putExtra("id",id.toString())
            intent.putExtra("name",name)
            intent.putExtra("email",email)
            intent.putExtra("phoneNumber",phoneNumber)
            intent.putExtra("address",address)
            intent.putExtra("latitude",latitude)
            intent.putExtra("longitude",longitude)
            intent.putExtra("toLatitude",toLatitude)
            intent.putExtra("toLongitude",toLongitude)


            startActivity(intent)
        }
    }
    private fun inputCheck(name: String?, email: String?, phoneNumber: String?, address: String?, latitude: String?, longitude: String?, toLatitude: String?, toLongtiude: String?): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(phoneNumber) && TextUtils.isEmpty(address) && TextUtils.isEmpty(latitude) && TextUtils.isEmpty(longitude) && TextUtils.isEmpty(toLatitude) && TextUtils.isEmpty(toLongtiude))
    }

    private fun backToPreviousPage(msg: String){
        toast(msg)
        val intent = Intent(this,UserList::class.java)
        startActivity(intent)
    }

    private fun toast(msg:String){
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}