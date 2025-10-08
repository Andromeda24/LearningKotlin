package com.example.lab6.async

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val forecast: Deferred<String> = async {
            getForecst()
        }
        val temperature: Deferred<String> = async {
            getTemperature()
        }
        println("Forecast: ${forecast.await()} and temperature ${temperature.await()}")

    }

    // launch  creates the coroutine and forget it. async wait for the result of  a suspend function
}

suspend fun getForecst(): String{
    return "Sunny"
}


suspend fun getTemperature(): String{
    delay(4000)
    return "81 F"
}