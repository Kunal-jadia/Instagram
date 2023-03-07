package com.example.instagram.models

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo

@Entity(tableName = "Users", indices = [Index(value = ["username"], unique = true)])
data class UsersInfo(

    @PrimaryKey(autoGenerate = true) val id : Int?,
    val email : String,
    val fullname : String,
    val username: String,
    val password : String
)
