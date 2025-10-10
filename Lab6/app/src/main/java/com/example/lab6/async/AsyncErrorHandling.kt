package com.example.lab6.async

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    testRunCatching()
}
fun testRunCatching() {
    runBlocking {
        val forecast = async {
            runCatching { // catching for errors. We also can use a try/catch
                getForecstE()
                error("something went wrong") // launch an exception if unhandled
                // raises IlegalStateException at runtime
            }

        }
        val temperature: Deferred<String> = async {
            getTemperatureE()
        }
        println("Forecast: ${forecast.await().getOrElse { "N/A" }} and temperature ${temperature.await()}")

    }

    // launch  creates the coroutine and forget it. async wait for the result of  a suspend function
}

suspend fun getForecstE(): String{
    return "Sunny"
}


suspend fun getTemperatureE(): String{
    delay(4000)
    return "81 F"
}