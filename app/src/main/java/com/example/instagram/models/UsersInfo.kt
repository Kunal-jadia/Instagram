package com.example.instagram.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UsersInfo(

    @PrimaryKey(autoGenerate = true) val id : Int?,
    val email : String?,
    val fullname : String?,
    val username: String?,
    val password : String?
)
