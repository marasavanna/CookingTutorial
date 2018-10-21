package com.halcyonmobile.cookingtutorial.stuff.consumers

import com.halcyonmobile.cookingtutorial.stuff.food.Burger
import com.halcyonmobile.cookingtutorial.stuff.food.FastFood
import com.halcyonmobile.cookingtutorial.stuff.food.Food

class Everybody : Consumer<Food> {
    override fun consume(item: Food) {
        println("Eat food")
    }
}

class ModernPeople : Consumer<FastFood> {
    override fun consume(item: FastFood) {
        println("Eat fast food")
    }
}

class AmericanPeople : Consumer<Burger> {
    override fun consume(item: Burger) {
        println("Eat burger")
    }
}

class DoStuff() {
    // This would work
    val consumer1: Consumer<Burger> = Everybody()
    val consumer2: Consumer<Burger> = ModernPeople()
    val consumer3: Consumer<Burger> = AmericanPeople()

    // 5 and 6 won't work
//    val consumer4: Consumer<Food> = Everybody()
//    val consumer5: Consumer<Food> = ModernPeople()
//    val consumer6: Consumer<Food> = AmericanPeople()
}