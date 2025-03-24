package com.example.splitapp.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.splitapp.data.local.model.entities.Group
import com.example.splitapp.data.local.model.entities.GroupUserCrossRef
import com.example.splitapp.data.local.model.entities.User

data class GroupWithUsers(
 @Embedded val group:Group,
    @Relation(
        parentColumn = "groupId",
        entityColumn = "userId",
        associateBy = Junction(GroupUserCrossRef::class)
    )
    val users:List<User>
)
