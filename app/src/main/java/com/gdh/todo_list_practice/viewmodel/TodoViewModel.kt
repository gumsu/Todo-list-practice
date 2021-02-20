package com.gdh.todo_list_practice.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.gdh.todo_list_practice.model.Todo
import com.gdh.todo_list_practice.repository.TodoRepository

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val mTodoRepository : TodoRepository
    private val mTodoItems : LiveData<List<Todo>>

    init {
        mTodoRepository = TodoRepository(application)
        mTodoItems = mTodoRepository.getAllTodoList()
    }

    fun deleteTodo(todo: Todo){
        mTodoRepository.deleteTodo(todo)
    }

    fun insertTodo(todo: Todo){
        mTodoRepository.insertTodo(todo)
    }

    fun getAllTodoList(): LiveData<List<Todo>>{
        return mTodoItems
    }

    fun updateTodo(todo: Todo){
        mTodoRepository.updateTodo(todo)
    }
}