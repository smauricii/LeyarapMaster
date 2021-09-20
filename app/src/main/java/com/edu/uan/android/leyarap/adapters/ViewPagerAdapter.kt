package com.edu.uan.android.leyarap.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.edu.uan.android.leyarap.fragments.*

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    companion object {
        private const val ARG_OBJECT = "object"
    }

    override fun getItemCount(): Int {
        return 6
    }
//aca toca aplicar todos los textos del fragmento NO OLVIDAR!!!!!!!!!!11
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                val fragment = FragmentEncuestaPausas()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment
            }
            1 -> {

                val fragment = FragmentEncuestaSalud()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment
            }
            2 -> {
                val fragment = FragmentEncuestaMeditacion()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment

            }
            3 -> {
                val fragment = FragmentEncuestaEstadoAnimo()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment

            }
            4 -> {
                val fragment = FragmentEncuestaMetasLogros()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment

            }
            5 -> {
                val fragment = FragmentEncuestaPensamientos()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment

            }
/*            6 -> {
                val fragment = FragmentHora()
                fragment.arguments = Bundle().apply {
                    // Our object is just an integer :-P
                    putInt(ARG_OBJECT, position + 1)
                }
                return fragment

            }*/
            else -> FragmentEncuestaPausas()
        }

    }
}