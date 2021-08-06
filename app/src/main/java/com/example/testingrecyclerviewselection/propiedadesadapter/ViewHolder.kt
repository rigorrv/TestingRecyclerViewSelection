package com.example.testingrecyclerviewselection.propiedadesadapter

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.testingrecyclerviewselection.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.direction_items.view.*
import kotlinx.android.synthetic.main.testselection_item.view.*

class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    // why update ui here? easier to access view without need to holder.titleTextView
    fun bind(item: ViewItem, isSelected: Boolean) {
        when (item) {
            is ViewItem.NumberItem -> {
                itemView.numberTextView.text = item.id
                val res =
                    if (isSelected) R.color.itemActivate else R.color.itemDisable
                itemView.setBackgroundResource(res)
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