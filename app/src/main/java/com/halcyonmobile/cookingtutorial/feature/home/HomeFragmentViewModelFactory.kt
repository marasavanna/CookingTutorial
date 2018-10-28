package com.halcyonmobile.cookingtutorial.feature.home

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.halcyonmobile.cookingtutorial.storage.CategoryRepository
import javax.inject.Inject

class HomeFragmentViewModelFactory @Inject constructor(private val categoryRepository: CategoryRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel(categoryRepository) as T
    }
}