package com.edu.uan.android.leyarap.actividadespasatiempos

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_consejos.*
import java.util.*

class Consejos : AppCompatActivity() {
    lateinit var mTTS: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consejos)

         textEt1.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")

        textEt1.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        var consejoRandom = mutableListOf(R.string.txt_consejo1,R.string.txt_consejo2,R.string.txt_consejo3,R.string.txt_consejo4,R.string.txt_consejo5)


        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR){
                mTTS.language = Locale("es","ES")
            }
        })

        speakBtn1.setOnClickListener {
            textEt1.setText(consejoRandom.random())//
            val toSpeack = textEt1.text.toString()
            if (toSpeack == ""){
                Toast.makeText(this, "NO HAY TEXTO PARA LEER", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, toSpeack, Toast.LENGTH_SHORT).show()
                mTTS.speak(toSpeack,TextToSpeech.QUEUE_FLUSH,null,)
            }
        }

        stopBtn1.setOnClickListener {
            if(mTTS.isSpeaking){
                mTTS.stop()
                //mTTS.shutdown()
            }else{
                Toast.makeText(this, "NO HAY TEXTO PARA LEER", Toast.LENGTH_SHORT).show()
            }
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