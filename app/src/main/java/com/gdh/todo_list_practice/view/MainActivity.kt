package com.gdh.todo_list_practice.view

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.view.get
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gdh.todo_list_practice.R
import com.gdh.todo_list_practice.databinding.ActivityMainBinding
import com.gdh.todo_list_practice.model.Todo
import com.gdh.todo_list_practice.view.adapter.TodoListAdapter
import com.gdh.todo_list_practice.viewmodel.TodoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.todo_list_item.*
import kotlinx.android.synthetic.main.todo_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var mTodoViewModel : TodoViewModel
    private lateinit var mTodoListAdapter: TodoListAdapter
    private val mTodoItems: ArrayList<Todo> = ArrayList()
    private lateinit var mDataBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataBinding()
        initRecyclerView()
        initAddButton()
        initViewModel()
        observeViewModel()
    }
    private fun initDataBinding() {
        mDataBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private fun initViewModel(){
        mTodoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(TodoViewModel::class.java).also {
            mDataBinding.viewMdoel = it
        }
    }

    private fun observeViewModel(){
        mTodoViewModel.getAllTodoList().observe(this, Observer {
            mTodoListAdapter.setTodoItems(it)
        })
    }
    private fun initAddButton(){
        btn_add_todo.setOnClickListener {
            val content = et_todo.text.toString()
            et_todo.text.clear()
            val date = Date().time
            val todo = Todo(null, content, date)
            mTodoViewModel.insertTodo(todo)
        }
    }

    private fun initRecyclerView(){
        mTodoListAdapter = TodoListAdapter().apply {
            listener = object :TodoListAdapter.onTodoItemClickListener {
                override fun deleteButton(position: Int) {
                    mTodoViewModel.deleteTodo(getTodoItem(position))
                }

                override fun changeStateButton(position: Int, isChecked: Boolean) {
                    if (isChecked) {
                        Log.d("로그", "cancelButton: $position 체크")
                        mDataBinding.rvTodoList[position].tv_todo_content.apply {
                            paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                            setTextColor(Color.GRAY)
                            setTypeface(null, Typeface.ITALIC)
                        }
                    }
                    else {
                        Log.d("로그", "cancelButton: $position 체크해제")
                        mDataBinding.rvTodoList[position].tv_todo_content.apply {
                            paintFlags = 0
                            setTextColor(Color.BLACK)
                            setTypeface(null, Typeface.NORMAL)
                        }
                    }
                }

                override fun modifyButton(position: Int) {
                    Log.d("로그", "modifyButton: $position 수정")
                }
            }
        }
        rv_todo_list.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mTodoListAdapter
        }
    }

    object BindingAdapters{
        @JvmStatic
        @BindingAdapter("todoDate")
        fun setTodoDate(tv: TextView, date: Long){
            val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm",Locale.getDefault())
            tv.text = simpleDateFormat.format(date)
        }

    }
}