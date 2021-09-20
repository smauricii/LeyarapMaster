package com.edu.uan.android.leyarap.salud

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaSalud
import com.edu.uan.android.leyarap.database.AppDatabaseSalud
import kotlinx.android.synthetic.main.activity_crear_evento_salud.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearEventoSaludActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_evento_salud)

        var iditemSalud: Int? = null

        if (intent.hasExtra("listaItemSalud")) {
            val itemLista = intent.extras?.getSerializable("listaItemSalud") as ListaSalud

            edit_nombre_salud.setText(itemLista.titulo)
            iditemSalud = itemLista.idListaSalud
        }

        val database = AppDatabaseSalud.getDatabase(this)

        //assets
        txt_crear_evento_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_crear_evento_salud.setTextColor(Color.WHITE)

        txt_nombre_evento_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_nombre_evento_salud.setTextColor(Color.WHITE)

        txt_seleccion_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_seleccion_salud.setTextColor(Color.WHITE)


        btn_crear_salud.setOnClickListener {
            val nombre = edit_nombre_salud.text.toString()
            val lista = ListaSalud(nombre, R.drawable.imagen_fondo_salud)

            if(iditemSalud != null){
                CoroutineScope(Dispatchers.IO).launch {

                    lista.idListaSalud = iditemSalud

                    database.itemListaSalud().update(lista)

                    this@CrearEventoSaludActivity.finish()
                }
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    database.itemListaSalud().insetAll(lista)

                    this@CrearEventoSaludActivity.finish()
            }



            }

        }

    }
}