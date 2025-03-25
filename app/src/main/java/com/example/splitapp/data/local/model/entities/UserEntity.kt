package com.example.splitapp.data.local.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId:Int,
    val userName:String
)
