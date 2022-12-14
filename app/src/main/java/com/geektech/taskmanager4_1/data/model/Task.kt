package com.geektech.taskmanager4_1.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    val title:String? = null,
    val description:String? = null,
) : Serializable