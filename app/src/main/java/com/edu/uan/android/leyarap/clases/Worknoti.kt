package com.edu.uan.android.leyarap.clases

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.*
import com.edu.uan.android.leyarap.R
import com.edu.uan.android.leyarap.pausas.PausasActivasActivity
import java.util.*
import java.util.concurrent.TimeUnit

class Worknoti (context: Context, workerParameters: WorkerParameters):Worker(context,workerParameters){

    override fun doWork(): Result {

        val titulo = inputData.getString("titulo")
        val detalle = inputData.getString("detalle")
        val id = inputData.getLong("idnoti",0).toInt()

        notipie(titulo,detalle)
        return Result.success()
    }

    companion object{
        fun GuardarNoti(duracion:Long, data: Data?, tag:String?){
            val noti = OneTimeWorkRequest.Builder(Worknoti::class.java)
                .setInitialDelay(duracion,TimeUnit.MILLISECONDS).addTag(tag!!)
                .setInputData(data!!).build()
            val instance = WorkManager.getInstance()
            instance.enqueue(noti)

        }
    }

    private fun notipie(t:String?, d:String?){
        val id="mensaje"
        val nm = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder = NotificationCompat.Builder(applicationContext, id)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.P){
            val nc = NotificationChannel(id,"nuevo",NotificationManager.IMPORTANCE_HIGH)
            nc.description="Notificacion FCM"
            nc.setShowBadge(true)
            nm.createNotificationChannel(nc)
        }

        val intent = Intent(applicationContext, PausasActivasActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

        val pendingIntent = PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_ONE_SHOT)
        builder.setAutoCancel(true)
            .setWhen(System.currentTimeMillis())
            .setContentTitle(t)
            .setTicker("Nueva Notificacion")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText(d)
            .setContentIntent(pendingIntent)
            .setContentInfo("nuevo")
        val random = Random()
        val idNotify = random.nextInt(8000)
        assert(nm != null)
        nm.notify(idNotify,builder.build())


    }
}