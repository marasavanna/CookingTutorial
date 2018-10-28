package com.halcyonmobile.cookingtutorial.storage

import javax.inject.Inject

class CategoryRepository @Inject constructor() {

    private var categories: ArrayList<String> = ArrayList()

    init {
        populateCategoriesList()
    }

    private fun populateCategoriesList() {
        categories.add("Vegan")
        categories.add("Vegetarian")
        categories.add("Dessert")
        categories.add("Entries")
        categories.add("Brunch")
        categories.add("Dinner")
        categories.add("Lunch")
    }

    fun getCategories(): ArrayList<String> {
        return categories
    }
}