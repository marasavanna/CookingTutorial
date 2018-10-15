package com.halcyonmobile.cookingtutorial.feature.home

import com.halcyonmobile.cookingtutorial.feature.home.DishesAdapter
import com.halcyonmobile.cookingtutorial.storage.DishRepository


class DishesActivityViewModel(dishRepository: DishRepository) {
    var adapter: DishesAdapter = DishesAdapter()
    init {
        adapter.setDishList(dishRepository.getDishList())
    }
}