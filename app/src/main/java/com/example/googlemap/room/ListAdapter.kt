package com.example.googlemap.room

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.googlemap.R


class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_layout,parent,false)
        return MyViewHolder(view);
    }



    override fun getItemCount(): Int {
        return userList.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder?.bindItems(userList[position])

    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItems(user: User) {

            val name = itemView.findViewById<TextView>(R.id.name)
            val email = itemView.findViewById<TextView>(R.id.email)
            val phoneNumber = itemView.findViewById<TextView>(R.id.phoneNumber)
            val address = itemView.findViewById<TextView>(R.id.address)
            val latitude = itemView.findViewById<TextView>(R.id.latitude)
            val longitude = itemView.findViewById<TextView>(R.id.longitude)
            val toLatitude = itemView.findViewById<TextView>(R.id.toLatitude)
            val toLongitude = itemView.findViewById<TextView>(R.id.toLongitude)

            name.text = user.name
            email.text = user.email
            phoneNumber.text = user.phoneNumber
            address.text = user.address
            latitude.text = user.latitude
            longitude.text = user.longitude
            toLatitude.text = user.toLatitude
            toLongitude.text = user.toLongitude


            itemView.setOnClickListener{
                val intent = Intent(itemView.context, Edit::class.java)
                intent.putExtra("id",user.id)
                intent.putExtra("name",user.name)
                intent.putExtra("email",user.email)
                intent.putExtra("phoneNumber",user.phoneNumber)
                intent.putExtra("address",user.address)
                intent.putExtra("latitude",user.latitude)
                intent.putExtra("longitude",user.longitude)
                intent.putExtra("toLatitude",user.toLatitude)
                intent.putExtra("toLongitude",user.toLongitude)
                itemView.context.startActivity(intent)
            }
        }
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

}