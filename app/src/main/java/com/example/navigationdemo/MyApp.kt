package com.example.navigationdemo

import android.app.Application
import timber.log.Timber

/**
 *company：成都标学科技有限公司
 *date：2021/10/13 下午1:46
 *coder：gzq
 *email：guozhiqiang@zlketang.com
 *description:
 */

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}