package com.gdh.todo_list_practice.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gdh.todo_list_practice.R
import com.gdh.todo_list_practice.databinding.TodoListItemBinding
import com.gdh.todo_list_practice.model.Todo

class TodoListAdapter() : RecyclerView.Adapter<TodoListAdapter.CustomTodoViewHolder>(){
    private var todoItems: List<Todo> = listOf()
    var listener: onTodoItemClickListener? = null

    interface onTodoItemClickListener{
        fun deleteButton(position: Int)
        fun changeStateButton(position: Int, isChecked: Boolean)
        fun modifyStateButton(position: Int)
        fun modifyButton(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListAdapter.CustomTodoViewHolder {
        return DataBindingUtil.inflate<TodoListItemBinding>(LayoutInflater.from(parent.context),R.layout.todo_list_item, parent, false).let {
            CustomTodoViewHolder(it, listener)
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

    fun getTodoItem(position: Int): Todo{
        return todoItems[position]
    }
    fun getTodoItemCount(): Int {
        return todoItems.size
    }

    class CustomTodoViewHolder(private val binding : TodoListItemBinding, listener: onTodoItemClickListener?) : RecyclerView.ViewHolder(binding.root){

        private val deleteTodoItem = binding.ivTodoDelete
        private val cancelTodoItem = binding.checkBox
        private val modifyStateTodoItem = binding.tvTodoContent
        private val modifyTodoItem = binding.etTodoContent

        init {
            deleteTodoItem.setOnClickListener {
                listener?.deleteButton(adapterPosition)
            }
            cancelTodoItem.setOnCheckedChangeListener { compoundButton, isChecked ->
                listener?.changeStateButton(adapterPosition, isChecked)
            }
            modifyStateTodoItem.setOnLongClickListener {
                listener?.modifyStateButton(adapterPosition)
                return@setOnLongClickListener true
            }
            modifyTodoItem.setOnClickListener {
                listener?.modifyButton(adapterPosition)
            }
        }

        fun bind(todo: Todo){
            binding.model = todo
            binding.executePendingBindings()
        }
    }
}