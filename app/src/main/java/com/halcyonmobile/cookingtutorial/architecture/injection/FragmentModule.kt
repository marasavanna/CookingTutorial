package com.halcyonmobile.cookingtutorial.architecture.injection

import com.halcyonmobile.cookingtutorial.feature.favorites.FavoritesFragment
import com.halcyonmobile.cookingtutorial.feature.dish.DishFragment
import com.halcyonmobile.cookingtutorial.feature.home.HomeFragment
import com.halcyonmobile.cookingtutorial.feature.settings.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeFavouritesFragment(): FavoritesFragment

    @ContributesAndroidInjector
    abstract fun contributeSettingsFragment(): SettingsFragment

    @ContributesAndroidInjector
    abstract fun contributeDishFragment(): DishFragment
}