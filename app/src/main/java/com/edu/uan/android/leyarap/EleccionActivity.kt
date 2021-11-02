package com.edu.uan.android.leyarap


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.edu.uan.android.leyarap.actividadespasatiempos.Bromas
import com.edu.uan.android.leyarap.actividadespasatiempos.Consejos
import com.edu.uan.android.leyarap.actividadespasatiempos.concentracion
import com.edu.uan.android.leyarap.estadoAnimo.EstadoAnimo
import com.edu.uan.android.leyarap.pausas.PausasActivasActivity
import com.edu.uan.android.leyarap.pensamientos.PensamientosActivity
import com.edu.uan.android.leyarap.salud.SaludActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_eleccion.*
import kotlinx.android.synthetic.main.activity_home.*
import java.text.SimpleDateFormat
import java.util.*

class EleccionActivity : AppCompatActivity() {
    //implementacion Firebase
    private val db = FirebaseFirestore.getInstance();
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


        val eleccionTriste = mutableListOf(Bromas::class.java,Consejos::class.java,SaludActivity::class.java)
        val eleccionNeutral = mutableListOf(PausasActivasActivity::class.java)
        val eleccionAlegre = mutableListOf(concentracion::class.java,PensamientosActivity::class.java)
        txt_inicio.setOnClickListener {
            val data = sliderpreg1.value
            //val intent = Intent(this, EstadoAnimo::class.java)
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("email", email)
            startActivity(intent)
        }
            //elegir todas las clases finales donde se an a dirigir las actividades
        btn_next.setOnClickListener {

            ////////////////
            val date = Date()
            val c: Calendar = Calendar.getInstance()
            c.setTime(date)
            val day: String = SimpleDateFormat("EEEE").format(date)

            if (email != null) {
                db.collection("datosUsuario").document(email+day).set(
                    hashMapOf("Animo" to sliderpreg1.value.toFloat(),
                        "Satisfaccion" to sliderpreg2.value.toFloat(),
                        "Suenio" to sliderpreg3.value.toFloat())
                )


            }

            /////////
            var suma = sliderpreg1.value + sliderpreg2.value + sliderpreg3.value
            if (suma  <= 5) {
                val intent = Intent(this, eleccionTriste.random())
                //intent.putExtra("dataestado", data)
                startActivity(intent)
                Toast.makeText(this, "Te sientes triste :( recomendamos realizar esta actividad" + eleccionTriste.toString(), Toast.LENGTH_SHORT).show()
            }else if(suma >5 && suma  <=10){
                val intent = Intent(this, eleccionNeutral.random())
                //intent.putExtra("dataestado", data)
                startActivity(intent)
                Toast.makeText(this, "Tu estado es normal te recomendamos realizar una pausa activa", Toast.LENGTH_SHORT).show()
            }else if(suma >10 && suma <=15){
                val intent = Intent(this, eleccionAlegre.random())
                //val intent = Intent(this, HomeActivity::class.java)
                //intent.putExtra("c", data)
                startActivity(intent)
                Toast.makeText(this, "Tu estado es alegre, te recomendamos realizar la siguiente actividad", Toast.LENGTH_SHORT).show()
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