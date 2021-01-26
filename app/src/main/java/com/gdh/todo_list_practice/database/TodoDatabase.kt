package com.gdh.todo_list_practice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gdh.todo_list_practice.model.Todo

@Database(entities = [Todo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDAO
}