package com.edu.uan.android.leyarap.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.fragment_encuesta_estado_animo.*
import kotlinx.android.synthetic.main.fragment_encuesta_meditacion.*


class FragmentEncuestaEstadoAnimo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encuesta_estado_animo, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(FragmentEncuestaPausas.ARG_OBJECT) }?.apply {
            title4.typeface = Typeface.createFromAsset(context?.assets, "fonts/lellaraptitle.otf")
            title4.text = "Estado De Animo"
            title4.setTextColor(Color.WHITE)

            parrafo4.text= "Graficamente Podras ver tu estado de animo segun lo has seleccionado a travez de los dias"
            parrafo4.setTextColor(Color.WHITE)
            parrafo4.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        }
    }
}