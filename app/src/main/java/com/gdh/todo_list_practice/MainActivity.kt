package com.gdh.todo_list_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdh.todo_list_practice.model.TodoModel
import com.gdh.todo_list_practice.view.adapter.TodoListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mTodoListAdapter: TodoListAdapter
    private val mTodoItems: ArrayList<TodoModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTodoItems.run {
            add(TodoModel("운동하기", 2021))
            add(TodoModel("공부하기", 2021))
            add(TodoModel("빨래하기", 2021))
            add(TodoModel("청소하기", 2021))
            add(TodoModel("학원가기", 2021))
            add(TodoModel("낮잠자기", 2021))
            add(TodoModel("일기쓰기", 2021))
            add(TodoModel("책사기", 2021))
            add(TodoModel("충전하기", 2021))
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