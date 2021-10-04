package com.edu.uan.android.leyarap

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.uan.android.leyarap.pausas.PausasActivasActivity
import com.edu.uan.android.leyarap.salud.CrearEventoSaludActivity
import com.edu.uan.android.leyarap.salud.SaludActivity
import kotlinx.android.synthetic.main.activity_eleccion.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_salud.*

class EleccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        val font = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")
        pregone?.typeface = font
        pregtwo?.typeface = font
        pregthree?.typeface = font

        btn_next.setOnClickListener {
            var suma = sliderpreg1.value + sliderpreg2.value + sliderpreg3.value
            if (suma  <= 5) {
                val intent = Intent(this, SaludActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Te recomendamos realizar una actividad de salud", Toast.LENGTH_SHORT).show()
            }else if(suma >5 && suma  <=10){
                val intent = Intent(this, PausasActivasActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Te recomendamos realizar una pausa activa", Toast.LENGTH_SHORT).show()
            }else if(suma >10 && suma <=15){
                val intent = Intent(this, InicioActicity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Te recomendamos ir al inicio jaja", Toast.LENGTH_SHORT).show()
            }
        }


    }
}