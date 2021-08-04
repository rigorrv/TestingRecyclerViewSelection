package com.example.testingrecyclerviewselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.ListAdapter
import timber.log.Timber

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
        Timber.d("position=$position, selected=${tracker.isSelected(position.toLong())}, selection=${tracker.selection}")
        holder.bind(getItem(position), tracker.isSelected(position.toLong()))
    }
}