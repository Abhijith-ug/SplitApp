package com.example.splitapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.splitapp.data.local.model.entities.GroupEntity
import com.example.splitapp.data.local.model.entities.GroupUserCrossRef
import com.example.splitapp.data.local.model.entities.UserEntity

@Database(entities = [UserEntity::class,GroupEntity::class,GroupUserCrossRef::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userGroupDao():UserGroupDao
}