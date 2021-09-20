package com.edu.uan.android.leyarap.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.fragment_encuesta_meditacion.*
import kotlinx.android.synthetic.main.fragment_encuesta_metas_logros.*


class FragmentEncuestaMetasLogros : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encuesta_metas_logros, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(FragmentEncuestaPausas.ARG_OBJECT) }?.apply {
            title5.typeface = Typeface.createFromAsset(context?.assets, "fonts/lellaraptitle.otf")
            title5.text = "Metas & Logros"
            title5.setTextColor(Color.WHITE)

            parrafo5.text= "Esta herramiente te ayuda a establecer pequeños objetivos para ayudarte a hacer las cosas que son importantes para ti, incluso cuando las emociones se interpongan. No tienes que una montaña hoy (o mañana)Comienza con estos retos, con el tiempo estas actividades se haran mas faciles y te sentiras mejor"
            parrafo5.setTextColor(Color.WHITE)
            parrafo5.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        }
    }
}