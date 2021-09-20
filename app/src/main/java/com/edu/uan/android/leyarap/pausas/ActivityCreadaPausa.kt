package com.edu.uan.android.leyarap.pausas

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaPausas
import com.edu.uan.android.leyarap.database.AppDatabase
import kotlinx.android.synthetic.main.activity__pausa_creada.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityCreadaPausa : AppCompatActivity() {
    private lateinit var database: AppDatabase
    private lateinit var listaitem: ListaPausas
    private lateinit var itemListLiveData: LiveData<ListaPausas>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity__pausa_creada)


        txt_title_lista.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_title_lista.setTextColor(Color.WHITE)
        title_ejemplo.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        title_ejemplo.setTextColor(Color.WHITE)

        val idLista = intent.getIntExtra("id", 0)

        database = AppDatabase.getDatabase(this)

        itemListLiveData = database.itemLista().get(idLista)
        itemListLiveData.observe(this, Observer {
            listaitem = it

            txt_title_lista.text = listaitem.titulo
        })

        btn_cinco.setOnClickListener {
            val intent = Intent(this, CincoPausaActivity::class.java)
            intent.putExtra("Titulo", listaitem.titulo)
            startActivity(intent)
        }
        btn_diez.setOnClickListener {
            val intent = Intent(this, DiezPausaActivity::class.java)
            intent.putExtra("Titulo", listaitem.titulo)
            startActivity(intent)
        }
            btn_quince.setOnClickListener {
            val intent = Intent(this, QuincePausaActivity::class.java)
            intent.putExtra("Titulo", listaitem.titulo)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_item -> {
                val intent = Intent(this, CrearEventoPusaActivity::class.java)
                intent.putExtra("listaitem", listaitem)
                startActivity(intent)
            }
            R.id.delete_item -> {
                val builder = AlertDialog.Builder(this)

                builder.setTitle("Estas seguro de eliminar ${listaitem.titulo} ?")
                builder.setPositiveButton("Eliminar") { dialogInterface: DialogInterface, i: Int ->
                    itemListLiveData.removeObservers(this)

                    CoroutineScope(Dispatchers.IO).launch {
                        database.itemLista().delete(listaitem)
                        this@ActivityCreadaPausa.finish()
                    }
                }
                builder.setNegativeButton("Cancelar",
                    { dialogInterface: DialogInterface, i: Int -> })
                builder.show()

            }
        }
        return super.onOptionsItemSelected(item)
    }
}
