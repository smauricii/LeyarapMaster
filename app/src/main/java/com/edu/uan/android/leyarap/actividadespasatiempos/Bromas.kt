package com.edu.uan.android.leyarap.actividadespasatiempos

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Toast
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_bromas.*
import java.util.*
import kotlin.collections.ArrayList

class Bromas : AppCompatActivity() {
    //text to spetch
    lateinit var mTTS:TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bromas)
        textEt.typeface = Typeface.createFromAsset(assets, "fonts/moon.otf")
        var chisteRandom = mutableListOf(R.string.txt_chiste1,R.string.txt_chiste2,R.string.txt_chiste3,R.string.txt_chiste4,R.string.txt_chiste5)


        mTTS = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if(status != TextToSpeech.ERROR){
                mTTS.language = Locale("es","ES")
            }
        })

        speakBtn.setOnClickListener {
            textEt.setText(chisteRandom.random())
            val toSpeack = textEt.text.toString()
            if (toSpeack == ""){
                Toast.makeText(this, "NO HAY TEXTO PARA LEER", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, toSpeack, Toast.LENGTH_SHORT).show()
                mTTS.speak(toSpeack,TextToSpeech.QUEUE_FLUSH,null,)
            }
        }

        stopBtn.setOnClickListener {
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