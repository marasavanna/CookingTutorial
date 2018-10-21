package com.halcyonmobile.cookingtutorial.architecture.injection

import android.app.Application
import com.halcyonmobile.cookingtutorial.CookingTutorialApplication
import com.halcyonmobile.cookingtutorial.feature.home.HomeFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityModule::class, FragmentModule::class])
interface AppComponent {

    fun inject(fragment: HomeFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(cookingTutorialApplication: CookingTutorialApplication)
}