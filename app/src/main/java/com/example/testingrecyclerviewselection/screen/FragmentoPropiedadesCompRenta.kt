package com.example.testingrecyclerviewselection.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StableIdKeyProvider
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testingrecyclerviewselection.R
import com.example.testingrecyclerviewselection.propiedadesadapter.LocalItemDetailsLookup
import com.example.testingrecyclerviewselection.propiedadesadapter.PropidadesAdapter
import com.example.testingrecyclerviewselection.propiedadesadapter.ViewItem
import kotlinx.android.synthetic.main.fragment_propiedades.*


class FragmentoPropiedadesCompRenta : Fragment() {
    private lateinit var adapter: PropidadesAdapter
    private var selection = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_propiedades, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initList()
    }

    private fun initList() {
        val layoutManager = LinearLayoutManager(context)
        list.layoutManager = layoutManager

        if (!::adapter.isInitialized) {
            adapter = PropidadesAdapter()
            adapter.setHasStableIds(true)
            list.adapter = adapter

            val tracker = SelectionTracker.Builder<Long>(
                "number-selection",
                list,
                StableIdKeyProvider(list),
                LocalItemDetailsLookup(list),
                StorageStrategy.createLongStorage()
            ).withSelectionPredicate(object : SelectionTracker.SelectionPredicate<Long>() {
                override fun canSetStateForKey(key: Long, nextState: Boolean): Boolean {
                    if (nextState == false) {
                        Toast.makeText(context, "Next Fragment", Toast.LENGTH_SHORT).show()
                    }
                    return true
                }

                override fun canSetStateAtPosition(position: Int, nextState: Boolean): Boolean {
                    return true
                }

                override fun canSelectMultiple(): Boolean {
                    return false // Set to false to allow single selecting
                }
            }).build()

            adapter.tracker = tracker
        }

        val items = mutableListOf<ViewItem>()
        for (number in 1..10) {
            items.add(ViewItem.NumberItem(number.toString()))
        }
        adapter.submitList(items)
    }
}
