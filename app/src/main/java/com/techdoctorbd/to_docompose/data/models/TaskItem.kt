package com.techdoctorbd.to_docompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.techdoctorbd.to_docompose.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class TaskItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: TaskPriority
)
