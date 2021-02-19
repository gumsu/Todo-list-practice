package com.gdh.todo_list_practice.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdh.todo_list_practice.R
import com.gdh.todo_list_practice.databinding.TodoListItemBinding
import com.gdh.todo_list_practice.model.Todo
import kotlinx.android.synthetic.main.todo_list_item.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate

class TodoListAdapter() : RecyclerView.Adapter<TodoListAdapter.CustomTodoViewHolder>(){
    private var todoItems: List<Todo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListAdapter.CustomTodoViewHolder {
        return DataBindingUtil.inflate<TodoListItemBinding>(LayoutInflater.from(parent.context),R.layout.todo_list_item, parent, false).let {
            CustomTodoViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: TodoListAdapter.CustomTodoViewHolder, position: Int) {
        (holder as? CustomTodoViewHolder)?.bind(todoItems.getOrNull(position) ?: return)
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }

    fun setTodoItems(todoItems: List<Todo>){
        this.todoItems = todoItems
        notifyDataSetChanged()
    }

    class CustomTodoViewHolder(private val binding : TodoListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(todo: Todo){
            binding.model = todo
            binding.executePendingBindings()
        }
    }
}