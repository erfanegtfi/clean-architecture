package com.clean.presentation

import android.app.Application
import com.clean.presentation.di.component.AppComponent
import com.clean.presentation.di.component.DaggerAppComponent

class App : Application() {

    lateinit var component: AppComponent


    override fun onCreate() {
        super.onCreate()

        createComponent()
        component.inject(this)
    }

    private fun createComponent() {
        component = DaggerAppComponent.factory().create(this);
    }

    fun getAppComponent(): AppComponent {
        return component
    }
}