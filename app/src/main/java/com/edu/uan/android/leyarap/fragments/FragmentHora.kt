package com.edu.uan.android.leyarap.fragments

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.edu.uan.android.leyarap.LoginActicity
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_hora.*


class FragmentHora : Fragment() {
    private val botonContinuar:ImageButton?=null




    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hora, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(FragmentEncuestaPausas.ARG_OBJECT) }?.apply {
            TitleHour.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
            TitleHour.text = "Establece una hora apropiada en el dia para ti"
            TitleHour.setTextColor(Color.WHITE)

            AzarDia.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
            AzarDia.setTextColor(Color.WHITE)

            AzarNoche.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
            AzarNoche.setTextColor(Color.WHITE)

            HoraEspecifica.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
            HoraEspecifica.setTextColor(Color.WHITE)

            btnContinuar.setOnClickListener { abirLogin(view) }

        }
    }
    fun abirLogin(v:View) {

        val intent = Intent(activity, LoginActicity::class.java)
        startActivity(intent)
    }
}