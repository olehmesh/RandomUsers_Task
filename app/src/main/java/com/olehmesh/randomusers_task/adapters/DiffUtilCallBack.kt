package com.olehmesh.randomusers_task.adapters

import androidx.recyclerview.widget.DiffUtil
import com.olehmesh.randomusers_task.models.Result

class DiffUtilCallBack : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem == newItem
    }

}