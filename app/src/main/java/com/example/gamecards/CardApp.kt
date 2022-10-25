package com.example.gamecards

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Igor Santos
 * 24/10/2022
 */

@HiltAndroidApp
class CardApp : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}