package com.example.cfseeker

import android.app.Application
import com.example.cfseeker.di.component.ApplicationComponent
import com.example.cfseeker.di.component.DaggerApplicationComponent
import com.example.cfseeker.di.module.ApplicationModule

class MyApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}