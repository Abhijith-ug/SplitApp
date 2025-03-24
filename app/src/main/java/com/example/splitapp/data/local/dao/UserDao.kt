package com.example.splitapp.data.local.dao

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.splitapp.data.local.model.entities.User
import com.example.splitapp.data.local.model.relations.UserWithGroups

interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    suspend fun getUserWithGroups(userId: Int): UserWithGroups

}