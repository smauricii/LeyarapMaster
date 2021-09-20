package com.edu.uan.android.leyarap.pausas

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.edu.uan.android.leyarap.R
import kotlinx.android.synthetic.main.activity_diez_pausa.*

class DiezPausaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diez_pausa)


        //videoViewCinco.setVideoURI(Uri.parse("android.resource://"+packageName + "/" +R.raw.prueba))
        videoViewDiez.setVideoURI(Uri.parse("android.resource://"+packageName + "/" +R.raw.dos))
        /*videoViewCinco.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=SA7AIQw-7Ms"))
        videoViewCinco.requestFocus();*/

        var media = MediaController(this)
        videoViewDiez.setMediaController(media)
        videoViewDiez.start()
    }
}