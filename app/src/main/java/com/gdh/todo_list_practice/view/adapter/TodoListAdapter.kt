package com.gdh.todo_list_practice.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gdh.todo_list_practice.R
import com.gdh.todo_list_practice.model.TodoModel
import kotlinx.android.synthetic.main.todo_list_item.view.*

class TodoListAdapter(val todoItems : ArrayList<TodoModel>) : RecyclerView.Adapter<TodoListAdapter.CustomTodoViewHolder>(){
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

    class CustomTodoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val content = itemView.tv_todo_content
        val date = itemView.tv_todo_date

        fun bind(todoModel: TodoModel){
            content.text = todoModel.content
            date.text = todoModel.date.toString()
        }
    }
}