package com.example.testingrecyclerviewselection.screen.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testingrecyclerviewselection.databinding.*
import androidx.fragment.app.commit
import com.example.testingrecyclerviewselection.R
import com.example.testingrecyclerviewselection.screen.dataSearch

class FragmentoAlberca : Fragment() {

    lateinit var rootView: FragmentAlbercaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FragmentAlbercaBinding.inflate(inflater, container, false)
        return rootView.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rootView.run {
            siguienteTxt.text = "Finalizar"
            titleTxt.text = "Buscas"
            subtitleTxt.text = "con alberca?"
            checkAlberca.setOnClickListener {
                if (checkAlberca.isChecked)
                    dataSearch.alberca = "true"
                else
                    dataSearch.alberca = "false"
            }
            siguienteTxt.setOnClickListener {
                activity?.supportFragmentManager?.commit {
                    replace(R.id.fragment2, FragmentSetUpSearch(), "VentaRenta")
                    addToBackStack(null)
                }
            }
        }
    }
}