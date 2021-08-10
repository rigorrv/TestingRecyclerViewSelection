package com.example.testingrecyclerviewselection.adapters.propiedadesadapter

import com.example.testingrecyclerviewselection.R


sealed class ViewItem(open val id: String, val resource: Int) {
    data class NumberItem(override val id: String) : ViewItem(id, R.layout.direction_items)
}
