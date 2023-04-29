package com.example.fiveone

import androidx.room.PrimaryKey

data class TodoItem (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val description: String,
    val completed: Boolean
)