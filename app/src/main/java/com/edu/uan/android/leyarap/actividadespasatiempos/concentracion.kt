package com.edu.uan.android.leyarap.actividadespasatiempos

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.view.View
import android.widget.Toast
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_concentracion.*
import kotlinx.android.synthetic.main.activity_pausas_activas.*
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timer

class concentracion : AppCompatActivity() {
    lateinit var mTTS: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concentracion)
        //temporizador
        var duracion = TimeUnit.MINUTES.toMillis(1)
        txt_temp.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")


        val terminacion = "El tiempo ha concluido, si quieres realizar una nueva actividad de concentración pulsar el botón de volmuen en la pantalla"
        var timer = object: CountDownTimer(duracion, 1000) {
            override fun onTick(l: Long) {
                var sDuration = String.format(Locale("es","ES"), "%02d: %02d",
                    TimeUnit.MILLISECONDS.toMinutes(l)
                    ,TimeUnit.MILLISECONDS.toSeconds(l)
                    ,TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l)))
                txt_temp.text = sDuration

            }

            override fun onFinish() {
                //txt_temp.visibility = View.GONE
                mTTS.speak(terminacion,TextToSpeech.QUEUE_FLUSH,null,)
                Toast.makeText(applicationContext, "El tiempo de la actividad ha terminado", Toast.LENGTH_SHORT).show()

            }
        }
        //fin temporizador

        textEt2.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        var concentracionRandom = mutableListOf(R.string.txt_concentracion1,R.string.txt_concentracion2,R.string.txt_concentracion3,R.string.txt_concentracion4,R.string.txt_concentracion5,R.string.txt_concentracion6)

        //Texto a voz
        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR){
                mTTS.language = Locale("es","ES")
            }
        })

        speakBtn2.setOnClickListener {
        /////////////////////////////// inicio cronometro

            timer.start()
            ///////////////////fin cronometro - inicio leer text view
            textEt2.setText(concentracionRandom.random())//
            val toSpeack = textEt2.text.toString()
            if (toSpeack == ""){
                Toast.makeText(this, "NO HAY TEXTO PARA LEER", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, toSpeack, Toast.LENGTH_SHORT).show()
                mTTS.speak(toSpeack,TextToSpeech.QUEUE_FLUSH,null,)
            }
        }

        stopBtn2.setOnClickListener {
            if(mTTS.isSpeaking){
                mTTS.stop()


                //mTTS.shutdown()
            }else{
                Toast.makeText(this, "NO HAY TEXTO PARA LEER", Toast.LENGTH_SHORT).show()
            }
            timer.cancel()
            timer.onFinish()
        }
    }
    override fun onPause() {
        if(mTTS.isSpeaking){
            mTTS.stop()
            //mTTS.shutdown()
        }
        super.onPause()
    }
}