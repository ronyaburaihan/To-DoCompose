package com.techdoctorbd.to_docompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techdoctorbd.to_docompose.data.models.TaskItem

@Database(entities = [TaskItem::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}