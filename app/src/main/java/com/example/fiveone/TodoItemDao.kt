package com.example.fiveone

import androidx.room.*

interface TodoItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoItem: TodoItem)

  //  @Query("SELECT * FROM todo_items WHERE id=:id")
    suspend fun getById(id: Int): TodoItem?

 //   @Query("SELECT * FROM todo_items ORDER BY id DESC")
    suspend fun getAll(): List<TodoItem>

    @Delete
    suspend fun delete(todoItem: TodoItem)


}
