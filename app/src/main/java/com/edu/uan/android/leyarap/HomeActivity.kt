package com.edu.uan.android.leyarap

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.edu.uan.android.leyarap.ejemplos.EstadoAnimoActivityCreadaEjemplo
import com.edu.uan.android.leyarap.ejemplos.MeditacionActivityCreadaEjemplo
import com.edu.uan.android.leyarap.ejemplos.MetasLogrosActivityCreadaEjemplo
import com.edu.uan.android.leyarap.pausas.PausasActivasActivity
import com.edu.uan.android.leyarap.pensamientos.PensamientosActivity
import com.edu.uan.android.leyarap.salud.SaludActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*



class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val font = Typeface.createFromAsset(assets, "fonts/texto_letras.ttf")
        txt_bienvenido?.setTypeface(font)
        emailtxt?.setTypeface(font)

        //setup PARA GUARDAR LOS DATOS QUE TENEMOS
        val bundle = intent.extras
        val email = bundle?.getString("email")
        setup(email ?:"")

        //GUARDAR LOS DATOS QUE TENEMOS
        val pref = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
        pref.putString("email",email)
        pref.apply()

        btn_pausas_act.setOnClickListener{pausasActivasAct()}
        btn_salud_act.setOnClickListener { salud() }
        //ejemplos dde clasese
        //meditacion
        btn_meditacion.setOnClickListener {
            val intent = Intent(this, MeditacionActivityCreadaEjemplo::class.java)
            startActivity(intent)
        }
        //estado de animo
        btn_estado_animo.setOnClickListener {
            val intent = Intent(this, EstadoAnimoActivityCreadaEjemplo::class.java)
            startActivity(intent)
        }
        //metas y logros
        btn_metas_logros.setOnClickListener {
            val intent= Intent(this, MetasLogrosActivityCreadaEjemplo::class.java)
            startActivity(intent)
        }
        //pensamientos

        btn_pensamientos.setOnClickListener {
            val intent = Intent(this, PensamientosActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setup(email:String){
        title ="Inicio"
        emailtxt.text ="${email}"
        //boton salir y guardado de preferencias
        btn_salir.setOnClickListener {

            val pref = getSharedPreferences(getString(R.string.prefs_file),Context.MODE_PRIVATE).edit()
            pref.clear()
            pref.apply()
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }


    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }


    private fun pausasActivasAct(){
        val pausaActivity = Intent(this, PausasActivasActivity::class.java)
        startActivity(pausaActivity)

    }
    private fun salud(){
        val intent = Intent(this, SaludActivity::class.java)
        startActivity(intent)
    }
}