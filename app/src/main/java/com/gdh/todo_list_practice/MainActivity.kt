package com.gdh.todo_list_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdh.todo_list_practice.model.Todo
import com.gdh.todo_list_practice.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mTodoListAdapter: TodoListAdapter
    private val mTodoItems: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTodoItems.run {
            add(Todo("운동하기", 2021))
            add(Todo("공부하기", 2021))
            add(Todo("빨래하기", 2021))
            add(Todo("청소하기", 2021))
            add(Todo("학원가기", 2021))
            add(Todo("낮잠자기", 2021))
            add(Todo("일기쓰기", 2021))
            add(Todo("책사기", 2021))
            add(Todo("충전하기", 2021))
        }
        initRecyclerView()
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