package com.example.testingrecyclerviewselection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.selection.*
import androidx.recyclerview.widget.*
import com.example.testingrecyclerviewselection.propiedadesadapter.LocalItemDetailsLookup
import com.example.testingrecyclerviewselection.propiedadesadapter.PropidadesAdapter
import com.example.testingrecyclerviewselection.propiedadesadapter.ViewItem
import kotlinx.android.synthetic.main.testselection.*
import timber.log.Timber

class FragmentoPropiedadesCompRenta : Fragment() {
    private lateinit var adapter: PropidadesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.testselection, container, false)
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

            tracker.addObserver(object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    Timber.d("selection=${tracker.selection}")
                }
            })
        }

        val items = mutableListOf<ViewItem>()
        for (number in 1..10) {
            items.add(ViewItem.NumberItem(number.toString()))
        }
        adapter.submitList(items)
    }
}
