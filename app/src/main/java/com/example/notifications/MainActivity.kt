package com.example.notifications

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val NOTIFICATION_ID = 87
        const val MESSAGE_ID = "46"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notification_btn.setOnClickListener {

            val intent = Intent(this, FullscreenActivity::class.java)
            intent.putExtra(MESSAGE_ID, "HELLO WORLD!")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

            val notification = Notification(this, MainActivity::class.java)
            notification.notificationPriority = NotificationCompat.PRIORITY_LOW
            notification.notify(NOTIFICATION_ID, getString(R.string.notification_title_main),
                getString(R.string.notification_content_main), pendingIntent)
        }
    }
}
