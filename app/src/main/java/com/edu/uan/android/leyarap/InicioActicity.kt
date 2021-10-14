package com.edu.uan.android.leyarap

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_inicio.*
import kotlinx.android.synthetic.main.activity_login.*

class InicioActicity : AppCompatActivity(), View.OnClickListener {
    var texto_inicio: TextView? = null
    var btnComenzar: ImageButton? = null
    var btnTEngoCn: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        //sesionActiva()
        //iniciolayout.visibility = View.VISIBLE
        texto_inicio = findViewById(R.id.textoinicio)
        texto_inicio!!.typeface = Typeface.createFromAsset(assets, "fonts/lellaraptitle.otf")

        btnComenzar = findViewById(R.id.btncomenzar)
        btnComenzar?.setOnClickListener(this)

        btnTEngoCn = findViewById(R.id.btntengocuenta)
        btnTEngoCn?.setOnClickListener(this)

    }

/*    private fun sesionActiva() {
        val pref = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = pref.getString("email", null)
        if (btnTEngoCn != null) {
            iniciolayout.visibility = View.INVISIBLE
        }
    }*/
    //acá van los botones que voy a agregar
    private fun proceso(opc: Int?) {
        when (opc) {
            R.id.btncomenzar -> {
                activiEncuesta()
            }
            R.id.btntengocuenta -> {
                abirLogin()
            }
        }
    }

    fun activiEncuesta() {
        val intent = Intent(this, EncuestaActicity::class.java)
        startActivity(intent)
    }

    fun abirLogin() {
        val intent = Intent(this, LoginActicity::class.java)
        startActivity(intent)
    }

    override fun onClick(p0: View?) {
        proceso(p0?.id)
    }

}