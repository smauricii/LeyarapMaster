package com.edu.uan.android.leyarap.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.uan.android.leyarap.LoginActicity
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.fragment_encuesta_pensamientos.*



class FragmentEncuestaPensamientos : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encuesta_pensamientos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(FragmentEncuestaPausas.ARG_OBJECT) }?.apply {
            title6.typeface = Typeface.createFromAsset(context?.assets, "fonts/lellaraptitle.otf")
            title6.text = "Pensamientos"
            title6.setTextColor(Color.WHITE)

            parrafo6.text= "Nuestros pensamientos acerca de nuestras experiencias tienen un gran impacto en nuestras respuestas emocionales a estos sucesos. A veces nuestros pensamientos no son verdaderos o justos, al observar detenidamente tus pensamientos, puedes trabajar en lograr interpretaciones mas equilibradas y precisas"
            parrafo6.setTextColor(Color.WHITE)
            parrafo6.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")

            btnContinuarP.setOnClickListener { abirLogin(view) }
        }
    }

    fun abirLogin(v:View) {

        val intent = Intent(activity, LoginActicity::class.java)
        startActivity(intent)
    }
}