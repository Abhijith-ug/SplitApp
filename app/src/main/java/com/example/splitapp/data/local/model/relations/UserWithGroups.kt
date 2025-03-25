package com.example.splitapp.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.splitapp.data.local.model.entities.GroupEntity
import com.example.splitapp.data.local.model.entities.GroupUserCrossRef
import com.example.splitapp.data.local.model.entities.UserEntity

data class UserWithGroups(
    @Embedded val user: UserEntity,
    @Relation(
        parentColumn = "userId",
        entityColumn = "groupId",
        associateBy = Junction(GroupUserCrossRef::class)

    )
    val groups: List<GroupEntity>
)
