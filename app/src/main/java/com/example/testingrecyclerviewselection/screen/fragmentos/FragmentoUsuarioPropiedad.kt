package com.example.testingrecyclerviewselection.screen.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.testingrecyclerviewselection.databinding.*
import com.example.testingrecyclerviewselection.model.DirectionJson


class FragmentoUsuarioPropiedad(private val info: DirectionJson) : Fragment() {

    private lateinit var rootView: FragmentoUsuarioPropiedadBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = FragmentoUsuarioPropiedadBinding.inflate(inflater, container, false)
        return rootView.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rootView.run {
            toolbar2.setNavigationOnClickListener {
                activity?.onBackPressed()
            }
            Glide.with(this@FragmentoUsuarioPropiedad)
                .load(info.foto)
                .into(avatarUsuario)
            usuarioTxt.text = info.usuario
            nombreUsuarioTxt.text = "Propietario:"
            usuarioNombreTxt.text = info.nombre
            correoUsuarioTxt.text = "Correo:"
            usuarioCorreoTxt.text = info.email
            telefonoUsuarioTxt.text = "Telefono:"
            usuarioTelefonoTxt.text = info.telefono
            direccionUsuarioTxt.text = "Direccion:"
            usuarioDireccionTxt.text = info.direccion
        }
    }

}