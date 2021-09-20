package com.edu.uan.android.leyarap.salud

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaSalud
import com.edu.uan.android.leyarap.database.AppDatabaseSalud
import kotlinx.android.synthetic.main.activity_creada_salud.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityCreadaSalud : AppCompatActivity() {
    private lateinit var database: AppDatabaseSalud
    private lateinit var listaItemSalud: ListaSalud
    private lateinit var itemListLiveData: LiveData<ListaSalud>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creada_salud)

        txt_title_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_title_salud.setTextColor(Color.WHITE)

        title_salud.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        title_salud.setTextColor(Color.WHITE)

        val idlista = intent.getIntExtra("id", 0)
        database = AppDatabaseSalud.getDatabase(this)

        itemListLiveData = database.itemListaSalud().get(idlista)
        itemListLiveData.observe(this, Observer {

            listaItemSalud = it
            txt_title_salud.text = listaItemSalud.titulo
        })

        btn_audio.setOnClickListener {
            sonido()

        }
        btn_audio2.setOnClickListener {
            sonido2()
        }
        btn_audio3.setOnClickListener {
            sonido3()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista_salud, menu)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.edit_item_salud -> {
                val intent = Intent(this, CrearEventoSaludActivity::class.java)
                intent.putExtra("listaItemSalud", listaItemSalud)
                startActivity(intent)

            }
            R.id.delete_item_salud -> {

                val builder = AlertDialog.Builder(this)

                builder.setTitle("Estas seguro de eliminar ${listaItemSalud.titulo} ?")
                builder.setPositiveButton("Eliminar") { dialogInterface: DialogInterface, i: Int ->

                    itemListLiveData.removeObservers(this)
                    CoroutineScope(Dispatchers.IO).launch {
                        database.itemListaSalud().delete(listaItemSalud)
                        this@ActivityCreadaSalud.finish()
                    }
                }
                builder.setNegativeButton("Cancelar",
                    { dialogInterface: DialogInterface, i: Int -> })
                builder.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun sonido() {

        val mp = MediaPlayer.create(this, R.raw.relajante)
        //val pn = MediaPlayer.create(this, R.raw.pruebam2)
        //mp.setAudioAttributes(AudioAttributes.Builder())

        mp.start()
        fun pausa(){
            if (mp!=null && mp.isPlaying){
                mp.currentPosition
                mp.pause()
            }
        }

    }
    private fun sonido2() {


        val pn = MediaPlayer.create(this, R.raw.relajante)
        //mp.setAudioAttributes(AudioAttributes.Builder())

        pn.start()

    }
    private fun sonido3() {


        val pn = MediaPlayer.create(this, R.raw.relajante)
        //mp.setAudioAttributes(AudioAttributes.Builder())

        pn.start()

    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(newBase)
        val override = Configuration(newBase.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
    }
}//fin on create


