package com.halcyonmobile.cookingtutorial.architecture.injection

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule {
    @Provides
    fun provideApplication(application: Application): Application {
        return application
    }
}