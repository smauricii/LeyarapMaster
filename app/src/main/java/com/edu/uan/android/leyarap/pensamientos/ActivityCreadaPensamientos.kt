package com.edu.uan.android.leyarap.pensamientos

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
import com.edu.uan.android.leyarap.clases.ListaPensamientos
import com.edu.uan.android.leyarap.database.AppDAtabasePensamientos
import kotlinx.android.synthetic.main.activity_creada_pensamientos.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityCreadaPensamientos : AppCompatActivity() {

    private lateinit var database: AppDAtabasePensamientos
    private lateinit var pensamientos: ListaPensamientos
    private lateinit var pensamietoLiveData: LiveData<ListaPensamientos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creada_pensamientos)

        txt_pensamientostitulo_creada.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_pensamientostitulo_creada.setTextColor(Color.WHITE)

        txt_descripcion_pensamientos.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_descripcion_pensamientos.setTextColor(Color.WHITE)


        database = AppDAtabasePensamientos.getDatabase(this)
        val idPensamientos = intent.getIntExtra("id", 0)

        pensamietoLiveData = database.itemListaPensamientos().get(idPensamientos)
        pensamietoLiveData.observe(this, Observer {

            pensamientos = it


            txt_pensamientostitulo_creada.text = pensamientos.titulo
            txt_descripcion_pensamientos.text = pensamientos.descripcion

        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_lista_pensamientos, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.edit_item_pensamientos -> {
                val intent = Intent(this, CrearEventoPensmientosActivity::class.java)
                intent.putExtra("pensamientos", pensamientos)
                startActivity(intent)

            }
            R.id.delete_item_pensamientos -> {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Estas seguro de eliminar ${pensamientos.titulo} ?")
                builder.setPositiveButton("Eliminar") { dialogInterface: DialogInterface, i: Int ->

                    pensamietoLiveData.removeObservers(this)

                    CoroutineScope(Dispatchers.IO).launch {
                        database.itemListaPensamientos().delete(pensamientos)
                        this@ActivityCreadaPensamientos.finish()
                    }
                }
                builder.setNegativeButton(
                    "Cancelar"
                ) { _: DialogInterface, i: Int -> }
                builder.show()

            }
        }
        return super.onOptionsItemSelected(item)
    }
}