package com.techdoctorbd.to_docompose.data

import androidx.room.*
import com.techdoctorbd.to_docompose.data.models.TaskItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<TaskItem>>

    @Query("SELECT * FROM todo_table WHERE id = :taskId")
    fun getSelectedTask(taskId: Int): Flow<TaskItem>

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchTasks(searchQuery: String): Flow<List<TaskItem>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<TaskItem>>

    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<TaskItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(taskItem: TaskItem)

    @Update
    suspend fun updateTask(taskItem: TaskItem)

    @Delete
    suspend fun deleteTask(taskItem: TaskItem)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()
}