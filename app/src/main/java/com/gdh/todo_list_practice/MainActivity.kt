package com.gdh.todo_list_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdh.todo_list_practice.model.Todo
import com.gdh.todo_list_practice.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mTodoListAdapter: TodoListAdapter
    private val mTodoItems: ArrayList<Todo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTodoItems.run {
            add(Todo("운동하기", Date().time))
            add(Todo("공부하기", Date().time))
            add(Todo("빨래하기", Date().time))
            add(Todo("청소하기", Date().time))
            add(Todo("학원가기", Date().time))
            add(Todo("낮잠자기", Date().time))
            add(Todo("일기쓰기", Date().time))
            add(Todo("책사기", Date().time))
            add(Todo("충전하기", Date().time))
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