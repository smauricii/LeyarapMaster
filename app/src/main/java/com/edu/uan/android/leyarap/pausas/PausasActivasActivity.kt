package com.edu.uan.android.leyarap.pausas

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.adapters.ListaAdapterPausa
import com.edu.uan.android.leyarap.clases.ListaPausas
import com.edu.uan.android.leyarap.database.AppDatabase
import kotlinx.android.synthetic.main.activity_pausas_activas.*
import android.annotation.SuppressLint as SuppressLint1
import androidx.annotation.RequiresApi as RequiresApi1


class PausasActivasActivity : AppCompatActivity() {

    private var search: SearchView? = null
    private var count = 0
    private var num = 10

    @SuppressLint1("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pausas_activas)
        actionBar?.setBackgroundDrawable(ColorDrawable(R.drawable.fondo))


        txt_pausa.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_pausa.setTextColor(Color.WHITE)


        var listaItem: List<ListaPausas> = emptyList<ListaPausas>()
        val database = AppDatabase.getDatabase(this)
        database.itemLista().getAll().observe(this, Observer {
            listaItem = it

            val adapter = ListaAdapterPausa(this, listaItem)

            lista_pausas.adapter = adapter
        })

        lista_pausas.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, ActivityCreadaPausa::class.java)
            intent.putExtra("id", listaItem[i].idLista)
            startActivity(intent)
        }

        btn_crearlista.setOnClickListener {
            val intent = Intent(this, CrearEventoPusaActivity::class.java)
            startActivity(intent)
        }
    }

    @RequiresApi1(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }


    //futura implementacion de busqueda filtrando datos en una lista
/*    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista, menu)
        search = menu?.findItem(R.id.app_bar_search)?.actionView as SearchView
        search!!.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS
        search!!.setOnQueryTextListener(this)
        return true

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
*//*        count =1
        if(!newText.equals("",ignoreCase = true)){
            search.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_NORMAL
            for(i in 0 until num){

            }

        }*//*
        return false
    }*/




}