package com.example.testingrecyclerviewselection

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffCallback : DiffUtil.ItemCallback<ViewItem>() {
    override fun areItemsTheSame(oldItem: ViewItem, newItem: ViewItem): Boolean {
        if (oldItem.resource != newItem.resource) return false
        // check if id is the same
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ViewItem, newItem: ViewItem): Boolean {
        // check if content is the same
        // equals using data class
        return oldItem == newItem
    }
}
