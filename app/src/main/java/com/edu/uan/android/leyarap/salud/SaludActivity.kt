package com.edu.uan.android.leyarap.salud

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.adapters.ListaAdapterSalud
import com.edu.uan.android.leyarap.clases.ListaSalud
import com.edu.uan.android.leyarap.database.AppDatabaseSalud
import kotlinx.android.synthetic.main.activity_salud.*

class SaludActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_salud)

        txt_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_salud.setTextColor(Color.WHITE)

        var listaSalud: List<ListaSalud> = emptyList<ListaSalud>()
        val database = AppDatabaseSalud.getDatabase(this)

        database.itemListaSalud().getAll().observe(this, Observer {
            listaSalud = it

            val adapter = ListaAdapterSalud(this,listaSalud)
            lista_salud_layout.adapter =adapter
        })



        lista_salud_layout.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ActivityCreadaSalud::class.java)
            intent.putExtra("id" ,listaSalud[position].idListaSalud)
            startActivity(intent)

        }

        btn_crearlista_salud.setOnClickListener {

            val intent = Intent(this, CrearEventoSaludActivity::class.java)
            startActivity(intent)
        }


    }
}