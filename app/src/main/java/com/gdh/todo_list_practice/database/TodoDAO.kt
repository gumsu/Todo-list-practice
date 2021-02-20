package com.gdh.todo_list_practice.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gdh.todo_list_practice.model.Todo

@Dao
interface TodoDAO {

    @Query("SELECT * FROM Todo ORDER BY date ASC")
    fun getAllTodoList() : LiveData<List<Todo>>

    @Insert
    fun insertTodo(todo:Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Query("SELECT count(*) FROM todo")
    fun getAllTodoCount() : LiveData<Int>
}