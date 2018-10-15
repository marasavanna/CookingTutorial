package com.halcyonmobile.cookingtutorial.model

class Ingredient(val name: String, private val vegetarian: Boolean, private val vegan: Boolean,
                 val price: Double, val calories: Int, val ingredients: ArrayList<Ingredient> = ArrayList()) {

    val totalCaloriesInIngredient: Int = ingredients.sumBy { it.calories }

    fun isVegan(): Boolean {
        return if (ingredients.size != 0) {
            ingredients.none { !it.isVegan() }
        } else vegan
    }

    fun isVegetarian(): Boolean {
        return if (ingredients.size != 0) {
            ingredients.none { !it.isVegetarian() }
        } else vegetarian
    }
}