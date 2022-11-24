package com.geektech.taskmanager4_1.data.local.datebase
import androidx.room.*
import com.geektech.taskmanager.data.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAllTask(): List<Task>

    @Insert
    fun insert(task: Task)
    @Delete
    fun delete(task: Task)
    @Update
    fun update(task: Task)
}