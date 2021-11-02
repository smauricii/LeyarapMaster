package com.edu.uan.android.leyarap.pensamientos

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.adapters.ListaAdapterPensamientos
import com.edu.uan.android.leyarap.clases.ListaPensamientos
import com.edu.uan.android.leyarap.database.AppDAtabasePensamientos
import kotlinx.android.synthetic.main.activity_pensamientos.*

class PensamientosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pensamientos)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        txt_pensamientos.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_pensamientos.setTextColor(Color.WHITE)



        var listaPensamientos = emptyList<ListaPensamientos>()
        val database = AppDAtabasePensamientos.getDatabase(this)

        database.itemListaPensamientos().getAll().observe(this, Observer {
            listaPensamientos=it

            val adapter = ListaAdapterPensamientos(this, listaPensamientos)

            lista_pensamientos_layout.adapter = adapter
        })

        lista_pensamientos_layout.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ActivityCreadaPensamientos::class.java)
            intent.putExtra("id",listaPensamientos[position].idPensamientos)
            startActivity(intent)
        }

        btn_crearlista_pensamientos.setOnClickListener {
            val intent = Intent(this, CrearEventoPensmientosActivity::class.java)
            startActivity(intent)
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