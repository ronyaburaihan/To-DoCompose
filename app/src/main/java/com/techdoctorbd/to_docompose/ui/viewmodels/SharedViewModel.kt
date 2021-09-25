package com.techdoctorbd.to_docompose.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techdoctorbd.to_docompose.data.models.TaskItem
import com.techdoctorbd.to_docompose.data.repositories.ToDoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SharedViewModel(private val repository: ToDoRepository) : ViewModel() {

    private val _allTasks = MutableStateFlow<List<TaskItem>>(emptyList())
    val allTasks: StateFlow<List<TaskItem>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }
}