package com.halcyonmobile.cookingtutorial.model

class Dish(val image: String, val name: String, val ingredients: ArrayList<Ingredient>?,
           var rating: Int, private val preparationTime: Double?, private val categories: ArrayList<String>?) {

    init {
        while (rating > 5) {
            rating--
        }
        while (rating < 0) {
            rating++
        }
    }

    val totalCalories: Int = ingredients?.sumBy { it.calories } ?: -1

    fun isVegan(): Boolean? = ingredients?.none { !it.isVegetarian() }

    fun isVegetarian(): Boolean? = ingredients?.none { !it.isVegan() }

    fun getTotalPrice(): Double? = ingredients?.sumByDouble { if (it.ingredients.isEmpty()) it.ingredients.sumByDouble { it.price } else it.price }

    fun getDishNationality(): String? {
        if (categories == null) {
            return ""
        }
        for (category in categories) if ((category != "Breakfast"
                        && category != "Dinner"
                        && category != "Dessert"
                        && category != "Lunch")) {
            return category
        }
        return ""
    }

    fun hasNationality(): Boolean = getDishNationality() != ""

    fun getActualTimeToMake(): Pair<Int?, Int?> {
        val hoursToMake: Int? = preparationTime?.toInt()
        val minutesToMake: Int? = preparationTime?.times(100)?.mod(100)?.toInt()
        val pair: Pair<Int?, Int?> = Pair(hoursToMake, minutesToMake)
        return Pair(hoursToMake, minutesToMake)
    }
}