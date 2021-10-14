package com.example.hilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 *company：成都标学科技有限公司
 *date：2021/10/14 下午2:17
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */
@HiltAndroidApp
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}