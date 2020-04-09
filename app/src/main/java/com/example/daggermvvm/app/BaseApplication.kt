package com.example.daggermvvm.app

import com.appizona.yehiahd.fastsave.FastSave
import com.example.daggermvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class BaseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        FastSave.init(applicationContext)
    }
}