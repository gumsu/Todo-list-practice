package com.gdh.todo_list_practice.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdh.todo_list_practice.R
import com.gdh.todo_list_practice.model.Todo
import kotlinx.android.synthetic.main.todo_list_item.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate

class TodoListAdapter(val todoItems : ArrayList<Todo>) : RecyclerView.Adapter<TodoListAdapter.CustomTodoViewHolder>(){
//    private var todoItems: List<TodoModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListAdapter.CustomTodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_list_item, parent, false)
        val viewHolder = CustomTodoViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: TodoListAdapter.CustomTodoViewHolder, position: Int) {
        val todoModel = todoItems[position]
        val todoViewHolder = holder as CustomTodoViewHolder
        todoViewHolder.bind(todoModel)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    fun addItem(todo : Todo){
        todoItems.add(todo)
    }

    class CustomTodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val content = itemView.tv_todo_content
        val date = itemView.tv_todo_date
        var sdf = SimpleDateFormat("yyyy년 M월 d일 a h시 m분")

        fun bind(todo: Todo){
            content.text = todo.content
            date.text = sdf.format(todo.date)
        }
    }
}