package com.edu.uan.android.leyarap.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.fragment_encuesta_salud.*


class FragmentEncuestaSalud : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encuesta_salud, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(FragmentEncuestaPausas.ARG_OBJECT) }?.apply {
            title2.typeface = Typeface.createFromAsset(context?.assets, "fonts/lellaraptitle.otf")
            title2.text = "Salud"
            title2.setTextColor(Color.WHITE)

            parrafo2.text= "La salud es un estado de bienestar o de equilibrio que puede ser visto a nivel subjetivo o a nivel objetivo, donde podras crear habitos diarios y mejorar tu forma de vida."
            parrafo2.setTextColor(Color.WHITE)
            parrafo2.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        }
    }
}