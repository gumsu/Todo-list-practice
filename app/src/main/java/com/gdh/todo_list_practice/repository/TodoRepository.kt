package com.gdh.todo_list_practice.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.gdh.todo_list_practice.database.TodoDAO
import com.gdh.todo_list_practice.database.TodoDatabase
import com.gdh.todo_list_practice.model.Todo

class TodoRepository(application: Application) {
    private var mTodoDatabase : TodoDatabase
    private var mTodoDAO : TodoDAO
    private var mTodoItems : LiveData<List<Todo>>

    init {
        mTodoDatabase = TodoDatabase.getInstance(application)
        mTodoDAO = mTodoDatabase.todoDao()
        mTodoItems = mTodoDAO.getAllTodoList()
    }

    fun getAllTodoList() : LiveData<List<Todo>>{
        return mTodoItems
    }

    fun insertTodo(todo: Todo){
        Thread(kotlinx.coroutines.Runnable {
            mTodoDAO.insertTodo(todo)
        }).start()
    }

    fun deleteTodo(todo: Todo){
        Thread(kotlinx.coroutines.Runnable {
            mTodoDAO.deleteTodo(todo)
        }).start()
    }
}