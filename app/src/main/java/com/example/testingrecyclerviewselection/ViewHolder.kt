package com.example.testingrecyclerviewselection

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.testselection_item.view.*

class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    // why update ui here? easier to access view without need to holder.titleTextView
    fun bind(item: ViewItem, isSelected: Boolean) {
        when (item) {
            is ViewItem.NumberItem -> {
                itemView.numberTextView.text = item.id
                val res =
                    if (isSelected) R.drawable.ic_baseline_add_circle_24 else R.drawable.ic_baseline_add_circle_outline_24
                itemView.selectionImageView.setImageResource(res)
            }
        }
    }

    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
        object : ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int = adapterPosition
            override fun getSelectionKey(): Long? = itemId
            override fun inSelectionHotspot(e: MotionEvent): Boolean {
                return true
            }

            override fun hasSelectionKey(): Boolean {
                return false
            }
        }
}