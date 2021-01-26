package com.gdh.todo_list_practice.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name = "comment")
    var content: String,

    @ColumnInfo(name = "date")
    var date: Long
)