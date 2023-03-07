package com.example.instagram.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.instagram.models.UsersInfo


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUser(usersInfo: UsersInfo)

    @Query("SELECT * FROM Users WHERE email = :email")
    suspend fun getUser(email : String) : UsersInfo

    @Query("SELECT * FROM Users")
    fun getAlluser() : LiveData<List<UsersInfo>>

    @Query("SELECT username FROM Users WHERE username = :username")
    fun userExist(username : String) : List<String>
}