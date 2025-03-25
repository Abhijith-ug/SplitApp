package com.example.splitapp.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.splitapp.data.local.model.entities.GroupEntity
import com.example.splitapp.data.local.model.entities.GroupUserCrossRef
import com.example.splitapp.data.local.model.entities.UserEntity

data class GroupWithUsers(
    @Embedded val group:GroupEntity,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "userId",
        associateBy = Junction(GroupUserCrossRef::class)
    )
    val users:List<UserEntity>
)
