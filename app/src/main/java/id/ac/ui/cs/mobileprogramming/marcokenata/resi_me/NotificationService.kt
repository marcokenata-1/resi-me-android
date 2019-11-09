package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*

class NotificationService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val intent2 = intent?.extras

        val calendar = intent2?.get("calendar") as Calendar
        Log.d("calendar",""+calendar.get(Calendar.HOUR_OF_DAY)+" "+calendar.get(Calendar.MINUTE))

        val intentReceiver = Intent(applicationContext, NotificationReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(applicationContext,100,intentReceiver,PendingIntent.FLAG_UPDATE_CURRENT)

        val alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,pendingIntent)
        return START_STICKY
    }
}