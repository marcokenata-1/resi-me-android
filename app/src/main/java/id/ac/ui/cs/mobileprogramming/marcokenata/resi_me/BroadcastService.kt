package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity


class BroadcastService : Service() {

    private val TAG = "BroadcastService"

    var cdt: CountDownTimer? = null

    var miliseconds : Long? = null

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    fun countdownMaker(intent: Intent?){
        cdt = object : CountDownTimer(intent?.getLongExtra("milli",10000)!!,1000){
            override fun onFinish() {
                val notificationManager = applicationContext?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

                val channelId = "app_channel_id"
                val channelName = "app_channel_name"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val notificationChannel =
                    NotificationChannel(channelId, channelName, importance)
                notificationManager.createNotificationChannel(notificationChannel)

                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

                val pendingIntent = PendingIntent.getActivity(applicationContext,100,intent, PendingIntent.FLAG_UPDATE_CURRENT)

                val builder : NotificationCompat.Builder = NotificationCompat.Builder(applicationContext,channelId)
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_check_black_24dp)
                    .setContentTitle("Resi-Me")
                    .setContentText("Timer has finished!")

                notificationManager.notify(101,builder.build())
            }

            override fun onTick(p0: Long) {
                Log.i(TAG, "Countdown seconds remaining: " + p0 / 1000)
                miliseconds = p0
                bi.putExtra("countdown", p0)
                sendBroadcast(bi)
            }

        }

        (cdt as CountDownTimer).start()

    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        if (intent != null) {
            countdownMaker(intent)
        }

        return START_NOT_STICKY
    }

    companion object {
        val COUNTDOWN_BR = "id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview.Home.countdown_br"
        var bi = Intent(COUNTDOWN_BR)
    }
}