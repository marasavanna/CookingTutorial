package com.halcyonmobile.cookingtutorial.data

import android.app.Application
import com.halcyonmobile.cookingtutorial.injection.AppComponent
import com.halcyonmobile.cookingtutorial.injection.AppModule
import com.halcyonmobile.cookingtutorial.injection.DaggerAppComponent


@Suppress("DEPRECATION")
class CookingTutorialApplication : Application() {

    companion object {
        lateinit var component: AppComponent
        fun getAppComponent(): AppComponent {
            return component
        }
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

}