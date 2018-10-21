package com.halcyonmobile.cookingtutorial.stuff.consumers

interface Consumer<in T> {
    fun consume(item: T)
}