package com.edu.uan.android.leyarap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.uan.android.leyarap.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_encuesta.*

class EncuestaActicity : AppCompatActivity() {
    private val adapter by lazy { ViewPagerAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta)
        pager.adapter = adapter
        val tabLayoutMediator =
            TabLayoutMediator(
                tab_layout,
                pager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    when (position) {
                        0 -> {
                            //tab.text = "hola"
                            tab.setIcon(R.drawable.ic_baseline_pause_24)
                        }
                        1 -> {
                            tab.text = ""
                            tab.setIcon(R.drawable.ic_baseline_healing_24)
                        }
                        2 -> {
                            tab.text = ""
                            tab.setIcon(R.drawable.ic_meditacion)
                        }
                        3 -> {
                            tab.text = ""
                            tab.setIcon(R.drawable.ic_baseline_insert_emoticon_24)
                        }
                        4 -> {
                            tab.text = ""
                            tab.setIcon(R.drawable.ic_premio)
                        }
                        5 -> {
                            tab.text = ""
                            tab.setIcon(R.drawable.ic_pensamiento)
                        }
/*                        6 -> {
                            tab.text = ""
                            tab.setIcon(R.drawable.ic_reloj)
                        }*/
                    }
                })
        tabLayoutMediator.attach()
    }
}