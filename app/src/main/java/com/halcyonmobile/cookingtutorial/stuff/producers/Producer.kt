package com.halcyonmobile.cookingtutorial.stuff.producers

interface Producer<out T> {
    fun produce(): T
}