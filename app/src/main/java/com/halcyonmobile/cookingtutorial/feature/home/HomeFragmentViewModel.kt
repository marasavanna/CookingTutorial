package com.halcyonmobile.cookingtutorial.feature.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.halcyonmobile.cookingtutorial.storage.CategoryRepository
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(var categoryRepository: CategoryRepository) : ViewModel() {

    var categories: MutableLiveData<ArrayList<String>> = MutableLiveData()

    init {
        getCategories()
    }

    private fun getCategories(): LiveData<ArrayList<String>> {
        loadData()
        return categories
    }

    private fun loadData() {
        categories.value = categoryRepository.getCategories()
    }
}