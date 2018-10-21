package com.halcyonmobile.cookingtutorial.stuff.producers

import com.halcyonmobile.cookingtutorial.stuff.food.Burger
import com.halcyonmobile.cookingtutorial.stuff.food.FastFood
import com.halcyonmobile.cookingtutorial.stuff.food.Food

class FoodStore : Producer<Food> {
    override fun produce(): Food {
        println("Produce Food")
        return Food()
    }
}

class FastFoodStore : Producer<FastFood> {
    override fun produce(): FastFood {
        println("Produce Fast Food")
        return FastFood()
    }
}

class InOutBurger : Producer<Burger> {
    override fun produce(): Burger {
        println("Produce Burger")
        return Burger()
    }
}

class DoStuff() {
    // This would work because OUT hey-word represents COVARIANCE, which states that an overriding method in a
    // child class can return a subtype of the initial return type in the overriden method from the parent class
    val producer1: Producer<Food> = FoodStore()
    val producer2: Producer<Food> = FastFoodStore()
    val producer3: Producer<Food> = InOutBurger()

    //What would not work with OUT key-word(COVARIANCE)
    //val producerX: Producer<Burger> = FoodStore()
    //Why? because food is not a subtype of burger, it's the other way around

}