package com.edu.uan.android.leyarap.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.fragment_encuesta_pausa.*


/**
 * A simple [Fragment] subclass.
 * Use the [FragmentEncuestaPausas.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentEncuestaPausas : Fragment() {
    companion object {
        const val ARG_OBJECT = "object"
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_encuesta_pausa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            title1.typeface = Typeface.createFromAsset(context?.assets, "fonts/lellaraptitle.otf")
            title1.text = "Pausas Activas"
            title1.setTextColor(Color.WHITE)

            parrafo1.text =
                "Breves descansos durante la jornada laboral que sirven para recuperar energia, mejorar el desempeño y eficiencia en el trabajo, y reducir el estrés."

            parrafo1.setTextColor(Color.WHITE)
            parrafo1.typeface = Typeface.createFromAsset(context?.assets, "fonts/moon.otf")
        }
    }

}