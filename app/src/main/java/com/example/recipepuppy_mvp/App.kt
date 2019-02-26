package com.example.recipepuppy_mvp

import android.app.Application
import com.example.recipepuppy_mvp.di.AppComponent
import com.example.recipepuppy_mvp.di.DaggerAppComponent

class App: Application(){
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
    }
    fun getComponent() = appComponent
}