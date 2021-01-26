package com.gdh.todo_list_practice.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdh.todo_list_practice.R
import com.gdh.todo_list_practice.model.Todo
import com.gdh.todo_list_practice.view.adapter.TodoListAdapter
import com.gdh.todo_list_practice.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mTodoViewModel : TodoViewModel
    private lateinit var mTodoListAdapter: TodoListAdapter
    private val mTodoItems: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initAddButton()
        initViewModel()
    }

    private fun initViewModel(){
        mTodoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(TodoViewModel::class.java)
    }

    private fun initAddButton(){
        btn_add_todo.setOnClickListener {
            val content = et_todo.text.toString()
            et_todo.text.clear()
            val date = Date().time
            val todo = Todo(null, content, date)
            mTodoListAdapter.addItem(todo)
            mTodoListAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView(){
        mTodoListAdapter = TodoListAdapter(mTodoItems)
        rv_todo_list.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mTodoListAdapter
        }
    }
}