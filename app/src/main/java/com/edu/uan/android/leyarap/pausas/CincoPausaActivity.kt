package com.edu.uan.android.leyarap.pausas

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_cinco_pausa.*

class CincoPausaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinco_pausa)

        //videoViewCinco.setVideoURI(Uri.parse("android.resource://"+packageName + "/" +R.raw.prueba))
        videoViewCinco.setVideoURI(Uri.parse("android.resource://"+packageName + "/" +R.raw.uno))
        /*videoViewCinco.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=SA7AIQw-7Ms"))
        videoViewCinco.requestFocus();*/

        var media = MediaController(this)
        videoViewCinco.setMediaController(media)
        videoViewCinco.start()
    }
}