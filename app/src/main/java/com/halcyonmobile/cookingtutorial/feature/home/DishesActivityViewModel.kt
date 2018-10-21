package com.halcyonmobile.cookingtutorial.feature.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.halcyonmobile.cookingtutorial.architecture.CookingTutorialViewModel
import com.halcyonmobile.cookingtutorial.model.Dish
import com.halcyonmobile.cookingtutorial.storage.DishRepository
import javax.inject.Inject

class DishesActivityViewModel @Inject constructor(private var dishRepository: DishRepository) : CookingTutorialViewModel() {
    private lateinit var dishes: MutableLiveData<List<Dish>>
    var adapter: DishesAdapter = DishesAdapter()

    init {
        adapter.setDishList(getDishes().value as ArrayList<Dish>)
    }

    private fun getDishes(): LiveData<List<Dish>> {
        if (!::dishes.isInitialized) {
            dishes = MutableLiveData()
            loadData()
        }
        return dishes
    }

    private fun loadData() {
        dishes.value = dishRepository.getDishList()
    }
}