package com.wasusi.androidnotifs

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    /**
     * We need to first create a notification channel, for devices above android oreo
     * The channel will host the notifications and hold the configurations we need for the notifications
     *
     * Each channel contains
     *  - channel id : unique string id
     *  - channel name : channel name
     * */
    val CHANNEL_ID = "my_channel_id"
    val CHANNEL_NAME = "awesome_channel"
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun createNotificationChannel(){
        /**
         * To create a notif channel first check if the device is running on android oreo or higher
         * A notif channel takes the following parameters
         *  - channel id
         *  - channel name
         *  - importance : dictates how essential a notification is
         * */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = Color.CYAN
                enableLights(true)
                enableVibration(true)
            }
        }
    }
}