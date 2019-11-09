package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        val notificationManager = p0?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(p0, MainActivity::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        Log.d("calendar",p1?.extras?.get("calendar").toString())

        val pendingIntent = PendingIntent.getActivity(p0,100,intent,PendingIntent.FLAG_UPDATE_CURRENT)

        val builder : NotificationCompat.Builder = NotificationCompat.Builder(p0)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_check_black_24dp)
            .setContentTitle("Resi-Me")
            .setContentText("You have a meal plan today! Don't forget to shop the ingredients!")
            .setAutoCancel(true)

        Log.d("calendar","notif lah bangsat 1")

        notificationManager.notify(101,builder.build())

        Toast.makeText(p0,"tolong lah gw tau this works",Toast.LENGTH_SHORT).show()

        Log.d("calendar","notif lah bangsat 2")
    }
}