package com.example.fiveone

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoListViewModel(application: Application) : AndroidViewModel(application) {
    private val todoDatabase = TodoDatabase.getInstance(application.applicationContext)

    val todoList: LiveData<List<TodoItem>> = liveData(Dispatchers.IO) {
        emit(todoDatabase.todoDao().getAll())
    }

    fun addTodoItem(title: String, description: String) {
        val todoItem = TodoItem(
            id = 0,
            title = title,
            description = description,
            completed = false
        )

        viewModelScope.launch {
            todoDatabase.todoDao().insert(todoItem)
        }
    }

    fun deleteTodoItem(todoItem: TodoItem) {
        viewModelScope.launch {
            todoDatabase.todoDao().delete(todoItem)
        }
    }
}