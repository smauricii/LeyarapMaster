package com.edu.uan.android.leyarap.pensamientos

import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaPensamientos
import com.edu.uan.android.leyarap.database.AppDAtabasePensamientos
import kotlinx.android.synthetic.main.activity_crear_evento_pensmientos.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearEventoPensmientosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_evento_pensmientos)

        var idPensamientos: Int? = null

        if (intent.hasExtra("pensamientos")) {
            val pensamientos = intent.extras?.getSerializable("pensamientos") as ListaPensamientos

            txt_nombre_pensamientos.setText(pensamientos.titulo)
            edit_descripcion.setText(pensamientos.descripcion)
            idPensamientos = pensamientos.idPensamientos
        }

        val database = AppDAtabasePensamientos.getDatabase(this)

        txt_nombre_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_nombre_evento.setTextColor(Color.WHITE)

        txt_crear_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_crear_evento.setTextColor(Color.WHITE)

        txt_seleccion.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_seleccion.setTextColor(Color.WHITE)

        btn_crear_pensamientos.setOnClickListener {
            val titulo = txt_nombre_pensamientos.text.toString()
            val descripcion = edit_descripcion.text.toString()

            val itemListaPensamientos = ListaPensamientos(titulo, descripcion, R.drawable.flores5)

            if (idPensamientos != null) {
                CoroutineScope(Dispatchers.IO).launch {
                    itemListaPensamientos.idPensamientos = idPensamientos

                    database.itemListaPensamientos().update(itemListaPensamientos)

                    this@CrearEventoPensmientosActivity.finish()
                }
            } else {
                CoroutineScope(Dispatchers.IO).launch {

                    database.itemListaPensamientos().insertAll(itemListaPensamientos)

                    this@CrearEventoPensmientosActivity.finish()
                }
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }
}