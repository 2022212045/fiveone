package com.example.fiveone

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoItemDao
    companion object {
        @Volatile private var instance: TodoDatabase? = null

        fun getInstance(context: Context): TodoDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): TodoDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java, "todo-database"
            ).build()
        }
    }
}