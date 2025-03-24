package com.example.splitapp.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.splitapp.data.local.model.entities.Group
import com.example.splitapp.data.local.model.entities.GroupUserCrossRef
import com.example.splitapp.data.local.model.relations.GroupWithUsers

interface GroupDao {
    // Insert Group
    @Insert
    suspend fun insertGroup(group: Group)

    // Get Group with Users
    @Transaction
    @Query("SELECT * FROM `Group` WHERE groupId = :groupId")
    suspend fun getGroupWithUsers(groupId: Int): GroupWithUsers

    // Add User to Group (Insert into Junction)
    @Insert
    suspend fun addUserToGroup(crossRef: GroupUserCrossRef)

    // Remove User from Group (Delete from Junction)
    @Delete
    suspend fun removeUserFromGroup(crossRef: GroupUserCrossRef)
}