package com.example.testingrecyclerviewselection.propiedadesadapter

import com.example.testingrecyclerviewselection.R

sealed class ViewItem(open val id: String, val resource: Int) {
    data class NumberItem(override val id: String) : ViewItem(id, R.layout.testselection_item)
}
