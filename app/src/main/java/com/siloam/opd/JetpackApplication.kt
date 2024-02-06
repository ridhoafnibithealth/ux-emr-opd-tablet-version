package com.siloam.opd

import android.app.Application
import com.siloam.opd.data.utils.NotificationUtil
import dagger.hilt.android.HiltAndroidApp
import io.armcha.debugBanner.Banner
import io.armcha.debugBanner.DebugBanner
//import io.armcha.debugBanner.Banner
//import io.armcha.debugBanner.DebugBanner
import timber.log.Timber

@HiltAndroidApp
class JetpackApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
        // Init Library
        NotificationUtil.createNotificationChannel(applicationContext)

        DebugBanner.init(application = this, banner = Banner(bannerText = "BETA", bannerColorRes = R.color.teal_700))
        // endregion
    }

}