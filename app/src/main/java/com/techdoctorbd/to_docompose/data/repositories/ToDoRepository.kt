package com.techdoctorbd.to_docompose.data.repositories

import com.techdoctorbd.to_docompose.data.ToDoDao
import com.techdoctorbd.to_docompose.data.models.TaskItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<TaskItem>> = toDoDao.getAllTasks()
    val sortByLowPriority: Flow<List<TaskItem>> = toDoDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<TaskItem>> = toDoDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<TaskItem> {
        return toDoDao.getSelectedTask(taskId)
    }

    suspend fun addTask(taskItem: TaskItem) {
        toDoDao.addTask(taskItem)
    }

    suspend fun updateTask(taskItem: TaskItem) {
        toDoDao.updateTask(taskItem)
    }

    suspend fun deleteTask(taskItem: TaskItem) {
        toDoDao.deleteTask(taskItem)
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String): Flow<List<TaskItem>> {
        return toDoDao.searchTasks(searchQuery)
    }
}