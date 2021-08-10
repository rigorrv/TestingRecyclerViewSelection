package com.example.testingrecyclerviewselection.screen.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testingrecyclerviewselection.databinding.*
import androidx.fragment.app.commit
import com.example.testingrecyclerviewselection.screen.dataSearch

class FragmentoEstancia : Fragment() {

    lateinit var rootView: FragmentEstanciaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FragmentEstanciaBinding.inflate(inflater, container, false)
        return rootView.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rootView.run {
            siguienteTxt.text = "Siguiente"
            titleTxt.text = "Buscas"
            subtitleTxt.text = "con estancia?"
            checkEstancia.setOnClickListener {
                if (checkEstancia.isChecked)
                    dataSearch.estancia = "true"
                else
                    dataSearch.estancia = "false"
            }
        }
    }
}