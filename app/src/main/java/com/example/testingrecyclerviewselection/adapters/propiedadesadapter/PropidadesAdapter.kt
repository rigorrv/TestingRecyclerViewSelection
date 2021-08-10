package com.example.testingrecyclerviewselection.adapters.propiedadesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.ListAdapter


class PropidadesAdapter() : ListAdapter<ViewItem, ViewHolder>(DiffCallback()) {
    lateinit var tracker: SelectionTracker<Long>

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemViewType(position: Int): Int {
        return getItem(position).resource
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(viewType, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), tracker.isSelected(position.toLong()))
    }
}