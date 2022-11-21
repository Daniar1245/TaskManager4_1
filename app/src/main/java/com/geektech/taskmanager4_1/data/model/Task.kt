package com.geektech.taskmanager4_1.data.model

import java.io.Serializable

data class Task( val title:String? = null,
                 val description:String? = null,
) : Serializable
