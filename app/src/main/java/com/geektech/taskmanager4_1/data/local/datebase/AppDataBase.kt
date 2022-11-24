package com.geektech.taskmanager4_1.data.local.datebase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.taskmanager.data.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun taskDao():TaskDao
}