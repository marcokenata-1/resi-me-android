package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity


class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val notificationManager = p0?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channelId = "app_channel_id"
        val channelName = "app_channel_name"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val notificationChannel =
            NotificationChannel(channelId, channelName, importance)
        notificationManager.createNotificationChannel(notificationChannel)

        val intent = Intent(p0, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        Log.d("calendar",p1?.extras?.get("calendar").toString())

        val pendingIntent = PendingIntent.getActivity(p0,100,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val builder : NotificationCompat.Builder = NotificationCompat.Builder(p0,channelId)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_check_black_24dp)
            .setContentTitle("Resi-Me")
            .setContentText("You have a meal plan today! Don't forget to shop the ingredients!")

        notificationManager.notify(101,builder.build())
    }
}