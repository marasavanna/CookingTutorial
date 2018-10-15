package com.halcyonmobile.cookingtutorial.storage

import com.halcyonmobile.cookingtutorial.model.Dish
import com.halcyonmobile.cookingtutorial.model.Ingredient
import javax.inject.Inject

class DishRepository @Inject constructor() {

    private val ingredients = ArrayList<Ingredient>()
    private val dishes = ArrayList<Dish>()

    init {
        populateDishList()
    }

    private fun populateDishList() {
        ingredients.add(Ingredient("Cheese", true, true, 23.00, 234))
        ingredients.add(Ingredient("Bread", true, true, 23.00, 234))
        ingredients.add(Ingredient("Pasta", true, true, 23.00, 234))
        ingredients.add(Ingredient("Tomatoes", true, true, 23.00, 234))
        ingredients.add(Ingredient("Garlic", true, true, 23.00, 234))
        ingredients.add(Ingredient("Parsley", true, true, 23.00, 234))
        ingredients.add(Ingredient("Ham", true, true, 23.00, 234))
        ingredients.add(Ingredient("Onions", true, true, 23.00, 234))
        ingredients.add(Ingredient("Peppers", true, true, 23.00, 234))
        ingredients.add(Ingredient("Feta", true, true, 23.00, 234))

        dishes.add(Dish("https://www.recipetineats.com/wp-content/uploads/2017/05/Lasagne-recipe-3-main.jpg", "Lasagna", ingredients, 2, 1.5, arrayListOf("Dinner", "Italian")))
        dishes.add(Dish("https://www.seriouseats.com/recipes/images/2014/12/20141204-slow-roasted-bolognese-01-1500x1125.jpg", "Bolognese", ingredients, 6, 0.5, arrayListOf("Dinner", "Italian")))
        dishes.add(Dish("https://clickpoftabuna.ro/wp-content/uploads/2016/04/cartofi-frantuzesti-580x400.jpg", "French Potatoes", ingredients, 3, 0.35, arrayListOf("Dinner", "French")))
        dishes.add(Dish("https://www.recipetineats.com/wp-content/uploads/2016/02/Beef-Hamburgers_7-2.jpg", "Hamburger", ingredients, 5, 1.2, arrayListOf("Lunch", "American")))
        dishes.add(Dish("https://www.recipetineats.com/wp-content/uploads/2016/02/Beef-Hamburgers_7-2.jpg", "Hamburger", ingredients, 5, 1.2, arrayListOf("Lunch", "American")))
    }

    fun getDishList(): ArrayList<Dish> {
        return dishes
    }
}