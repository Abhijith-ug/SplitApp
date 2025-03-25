package com.example.splitapp.data.local.model.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    primaryKeys = ["userId","groupId"],
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE),
       ForeignKey(
           entity = GroupEntity::class,
           parentColumns = ["groupId"],
           childColumns = ["groupId"],
           onDelete = ForeignKey.CASCADE
       )
    ]
)
data class GroupUserCrossRef(
    val userId:Int,
    val groupId:Int
)
