package com.edu.uan.android.leyarap.pensamientos

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}