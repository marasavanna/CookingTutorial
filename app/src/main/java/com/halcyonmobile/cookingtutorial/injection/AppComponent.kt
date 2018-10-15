package com.halcyonmobile.cookingtutorial.injection

import com.halcyonmobile.cookingtutorial.feature.home.DishesActivity
import com.halcyonmobile.cookingtutorial.feature.home.DishesActivityViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    //Activities
    fun inject(activity: DishesActivity)

    //View Models
    fun inject(viewModel: DishesActivityViewModel)

}