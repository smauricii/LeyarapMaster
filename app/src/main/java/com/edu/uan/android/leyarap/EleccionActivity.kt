package com.edu.uan.android.leyarap

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_eleccion.*
import kotlinx.android.synthetic.main.activity_home.*

class EleccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        val font = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")
        pregone?.typeface = font
        pregtwo?.typeface = font
        pregthree?.typeface = font

    }
}