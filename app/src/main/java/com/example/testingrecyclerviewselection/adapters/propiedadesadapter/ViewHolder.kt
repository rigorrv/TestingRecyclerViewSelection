package com.example.testingrecyclerviewselection.adapters.propiedadesadapter

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.testingrecyclerviewselection.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.direction_items.view.*

class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    // why update ui here? easier to access view without need to holder.titleTextView
    fun bind(item: ViewItem, isSelected: Boolean) {
        when (item) {
            is ViewItem.NumberItem -> {
                itemView.precioRecyclerTxt.text = "$8000"
                itemView.direccionRecyclerTxt.text = "Villas del Palmar"
                itemView.masInfoBtn.text = "Info aqui"
                itemView.houseIcon.setBackgroundResource(R.drawable.house0001)
                val res =
                    if (isSelected) View.VISIBLE else View.GONE
//                itemView.infoIcono.visibility = res
                itemView.masInfoBtn.visibility = res
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