package com.gdh.todo_list_practice.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.gdh.todo_list_practice.database.TodoDAO
import com.gdh.todo_list_practice.database.TodoDatabase
import com.gdh.todo_list_practice.model.Todo
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.*

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
        Observable.just(todo)
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTodoDAO.insertTodo(todo)
            }, {
            })
    }

    fun deleteTodo(todo: Todo){
        Observable.just(todo)
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTodoDAO.deleteTodo(todo)
            }, {

            })
    }

    fun updateTodo(todo: Todo){
        Observable.just(todo)
            .subscribeOn(Schedulers.io())
            .subscribe({
                mTodoDAO.updateTodo(todo)
            }, {

            })
    }

    fun getAllTodoCount(): LiveData<Int>{
        return mTodoDAO.getAllTodoCount()
    }
}