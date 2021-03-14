package com.example.googlemap.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblusers")
data class User(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val name: String,
        val email: String,
        val phoneNumber: String,
        val address: String,
        val latitude:String,
        val longitude:String,
        val toLatitude:String,
        val toLongitude:String
)