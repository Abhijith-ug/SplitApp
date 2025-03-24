package com.example.splitapp.data.local.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["createdBy"],
            onDelete = ForeignKey.CASCADE)
    ]
)
data class Group(
    @PrimaryKey(autoGenerate = true)
    val groupId:Int,
    val groupName:String,
    val createdBy:Int
)
