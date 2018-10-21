package com.halcyonmobile.cookingtutorial.feature.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.halcyonmobile.cookingtutorial.storage.DishRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class DishActivityViewModelFactory @Inject constructor(private val dishRepository: DishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DishesActivityViewModel(dishRepository) as T
    }
}