package com.edu.uan.android.leyarap.pausas

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_cinco_pausa.*
import kotlinx.android.synthetic.main.activity_quince_pausa.*

class QuincePausaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quince_pausa)


        //videoViewCinco.setVideoURI(Uri.parse("android.resource://"+packageName + "/" +R.raw.prueba))
        videoViewQuince.setVideoURI(Uri.parse("android.resource://"+packageName + "/" +R.raw.tres))
        /*videoViewCinco.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=SA7AIQw-7Ms"))
        videoViewCinco.requestFocus();*/

        var media = MediaController(this)
        videoViewQuince.setMediaController(media)
        videoViewQuince.start()
    }
}