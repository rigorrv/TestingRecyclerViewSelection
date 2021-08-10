package com.example.testingrecyclerviewselection.screen.fragmentos

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.testingrecyclerviewselection.FragmentoPropiedadesCompRenta
import com.example.testingrecyclerviewselection.R
import com.example.testingrecyclerviewselection.databinding.*
import com.example.testingrecyclerviewselection.databinding.*


class FragmentSetUpSearch : Fragment() {

    lateinit var rootView: FragmentoConfigurandoBusquedaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = FragmentoConfigurandoBusquedaBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rootView.aceptarInfoBtn.setOnClickListener {
            activity?.supportFragmentManager?.commit {
                replace(R.id.fragment2, FragmentoPropiedadesCompRenta(), "VentaRenta")
                addToBackStack(null)
            }
        }
    }

    private fun getInfo(boolean: Boolean) {
        if (boolean)
            rootView.progressBarInfo.visibility = View.VISIBLE
        else
            rootView.aceptarInfoBtn.visibility = View.GONE
    }
}