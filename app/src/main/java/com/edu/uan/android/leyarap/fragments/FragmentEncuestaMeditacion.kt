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


class FragmentEncuestaMeditacion : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encuesta_meditacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(FragmentEncuestaPausas.ARG_OBJECT) }?.apply {
            title3.typeface = Typeface.createFromAsset(context?.assets, "fonts/lellaraptitle.otf")
            title3.text = "Meditacion"
            title3.setTextColor(Color.WHITE)

            parrafo3.text= "Esta actividad puede ayudarte a relajarte o estar en paz contigo mismo, tanto si te encuentras en una situacion estresante o quieres relajarte tras un largo dia"
            parrafo3.setTextColor(Color.WHITE)
            parrafo3.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        }
    }
}