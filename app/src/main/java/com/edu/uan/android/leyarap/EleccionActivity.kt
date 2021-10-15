package com.edu.uan.android.leyarap


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.uan.android.leyarap.estadoAnimo.EstadoAnimo
import com.edu.uan.android.leyarap.pausas.PausasActivasActivity
import com.edu.uan.android.leyarap.pensamientos.PensamientosActivity
import com.edu.uan.android.leyarap.salud.SaludActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_eleccion.*
import kotlinx.android.synthetic.main.activity_home.*

class EleccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleccion)

        //setup PARA GUARDAR LOS DATOS QUE TENEMOS
        val bundle = intent.extras
        val email = bundle?.getString("email")
        setup(email ?:"")

        //GUARDAR LOS DATOS QUE TENEMOS
        val pref = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
        pref.putString("email",email)
        pref.apply()

        val font = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")
        pregone?.typeface = font
        pregtwo?.typeface = font
        pregthree?.typeface = font
        txt_inicio?.typeface = font
        txt_inicio?.setTextColor(Color.rgb(61, 165, 255))


        val eleccion = mutableListOf(PausasActivasActivity::class.java,PensamientosActivity::class.java,SaludActivity::class.java)
        txt_inicio.setOnClickListener {
            val data = sliderpreg1.value
            //val intent = Intent(this, EstadoAnimo::class.java)
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }

        btn_next.setOnClickListener {

            var suma = sliderpreg1.value + sliderpreg2.value + sliderpreg3.value
            if (suma  <= 5) {
                val intent = Intent(this, SaludActivity::class.java)
                //intent.putExtra("dataestado", data)
                startActivity(intent)
                Toast.makeText(this, "Te recomendamos realizar una actividad de salud", Toast.LENGTH_SHORT).show()
            }else if(suma >5 && suma  <=10){
                val intent = Intent(this, PausasActivasActivity::class.java)
                //intent.putExtra("dataestado", data)
                startActivity(intent)
                Toast.makeText(this, "Te recomendamos realizar una pausa activa", Toast.LENGTH_SHORT).show()
            }else if(suma >10 && suma <=15){
                val intent = Intent(this, eleccion.random())
                //val intent = Intent(this, HomeActivity::class.java)
                //intent.putExtra("c", data)
                startActivity(intent)
                Toast.makeText(this, "Te recomendamos ir al inicio jaja", Toast.LENGTH_SHORT).show()
            }
        }

    }
    //cambios
    private fun setup(email:String){
        title ="Inicio"
        emailuser.text ="${email}"
        //boton salir y guardado de preferencias
        salirbtn.setOnClickListener {

            val pref = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            pref.clear()
            pref.apply()
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }

}