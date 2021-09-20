package com.edu.uan.android.leyarap.pausas

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.work.Data
import androidx.work.WorkManager
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.clases.ListaPausas
import com.edu.uan.android.leyarap.clases.Worknoti
import com.edu.uan.android.leyarap.database.AppDatabase
import kotlinx.android.synthetic.main.activity_crear_evento_pusa.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class CrearEventoPusaActivity : AppCompatActivity() {

    private lateinit var listaitem: ListaPausas

    var actual = Calendar.getInstance()
    var calendar = Calendar.getInstance()
    private var minutos = 0
    private var hora =0
    private var dia =0
    private var mes =0
    private var anio =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_evento_pusa)

        var idListapausa: Int? =null

        if(intent.hasExtra("listaitem")){
            val itemLista = intent.extras?.getSerializable("listaitem") as ListaPausas

            txt_nombre.setText(itemLista.titulo)
            //txt_hora.setText(itemLista.diaHora)
            idListapausa = itemLista.idLista
        }

        val database = AppDatabase.getDatabase(this)

        txt_crear_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_crear_evento.setTextColor(Color.WHITE)

        txt_nombre_evento.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_nombre_evento.setTextColor(Color.WHITE)

        txt_seleccion.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        txt_seleccion.setTextColor(Color.WHITE)

//Notificaciones !!! NO OLVIDAR
        btn_fecha.setOnClickListener {
            anio = actual[Calendar.YEAR]
            mes = actual[Calendar.MONTH]
            dia = actual[Calendar.DAY_OF_MONTH]

            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, y, m, d ->
                calendar[Calendar.DAY_OF_MONTH] = d
                calendar[Calendar.MONTH] = m
                calendar[Calendar.YEAR] = y

                val format = SimpleDateFormat("dd/MM/yyy")
                val strDate = format.format(calendar.time)

                txt_fecha.setText(strDate)
                //txt_horaf

            },anio,mes,dia)
            datePickerDialog.show()
        }
        btn_hora.setOnClickListener {
            hora = actual[Calendar.HOUR_OF_DAY]
            minutos = actual[Calendar.MINUTE]

            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, o, p ->

                calendar[Calendar.HOUR_OF_DAY] = o
                calendar[Calendar.MINUTE] = p


                txt_horaf.setText(String.format("%02d:%02d",o,p))

            },hora,minutos,true)
            timePicker.show()
        }

// FIN NOTIFICACIONES

        btn_crear.setOnClickListener {


            if (txt_nombre.text.toString() != "") {
                val nombre = txt_nombre.text.toString()
                val hora = txt_horaf.text.toString()
                val lista = ListaPausas(nombre, hora, R.drawable.imagen_fondo1)
                if(idListapausa != null){
                    CoroutineScope(Dispatchers.IO).launch {
                        lista.idLista = idListapausa

                        database.itemLista().update(lista)
                        this@CrearEventoPusaActivity.finish()
                    }
                }else{
                    CoroutineScope(Dispatchers.IO).launch {
                        database.itemLista().insertAll(lista)

                        this@CrearEventoPusaActivity.finish()
                }


                }
            }else{
                Toast.makeText(this, "Por favor llena los datos", Toast.LENGTH_SHORT).show()
            }


                val tag = generateKey()
                val alertime = calendar.timeInMillis - System.currentTimeMillis()
                val random = (Math.random()*50 + 1).toInt()
                val data = enviarData(txt_nombre.text.toString(),"Detalle kotlin",random)
                Worknoti.GuardarNoti(alertime,data,"tag1")
                Toast.makeText(this, "Evento Creado", Toast.LENGTH_SHORT).show()




        }
    }//fin on create

    private fun generateKey():String{
        return  UUID.randomUUID().toString()
    }

    private fun enviarData(titulo:String,detalle:String,id_noti:Int):Data{

        return Data.Builder()
            .putString("titulo",titulo)
            .putString("detalle",detalle)
            .putInt("id_noti",id_noti).build()

    }

    private fun cancelarAlarma(tag:String){

        WorkManager.getInstance(this).cancelAllWorkByTag(tag)
        Toast.makeText(this,"Alarma Cancelada",Toast.LENGTH_SHORT).show()

    }
}