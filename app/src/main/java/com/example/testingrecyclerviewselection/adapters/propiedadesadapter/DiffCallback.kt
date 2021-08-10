package com.example.testingrecyclerviewselection.adapters.propiedadesadapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffCallback : DiffUtil.ItemCallback<ViewItem>() {
    override fun areItemsTheSame(oldItem: ViewItem, newItem: ViewItem): Boolean {
        if (oldItem.resource != newItem.resource) return false
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ViewItem, newItem: ViewItem): Boolean {
        return oldItem == newItem
    }
}
