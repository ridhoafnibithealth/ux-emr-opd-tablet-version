package com.siloam.opd.data.utils

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object NotificationUtil {
    private const val NAME = "Siloam Hospital"
    private const val CHANNEL = "OPD"
    private const val DESCRIPTION = "Siloam Hospital OPD Tablet Application"
    private const val NOTIF_PREFERENCES = "notif_preferences"
    private const val NOTIF_ID_KEY = "notification_id_key"

    @SuppressLint("ObsoleteSdkInt")
    fun createNotificationChannel(context: Context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL, NAME, importance).apply {
                description = DESCRIPTION
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}