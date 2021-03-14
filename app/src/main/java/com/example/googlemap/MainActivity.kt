package com.example.googlemap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.googlemap.room.MainPage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val map = findViewById<Button>(R.id.map)
        val roomMap = findViewById<Button>(R.id.roomMap)
        map.setOnClickListener{
            val intent = Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }

        roomMap.setOnClickListener{
            val intent1 = Intent(this,MainPage::class.java)
            startActivity(intent1)
        }
    }
}