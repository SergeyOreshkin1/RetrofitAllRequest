package com.example.retrofitallrequest.presentation

import android.app.Application
import com.example.retrofitallrequest.di.ApplicationComponent
import com.example.retrofitallrequest.di.DaggerApplicationComponent

class App : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}