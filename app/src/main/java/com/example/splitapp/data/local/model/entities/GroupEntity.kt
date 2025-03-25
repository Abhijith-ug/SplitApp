package com.example.splitapp.data.local.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["createdBy"],
            onDelete = ForeignKey.CASCADE)
    ]
)
data class GroupEntity(
    @PrimaryKey(autoGenerate = true)
    val groupId:Int,
    val groupName:String,
    val createdBy:Int,
    val groupDescription:String
)
