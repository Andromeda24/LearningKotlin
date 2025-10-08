package com.example.lab6.coroutinesvsthread

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.measureTime

fun main(){
    val times =100
    println("begin coroutines")
    runBlocking {
        val messureForCoroutine = measureTime {

        // launching many coroutines  do not block the system
            repeat(times) {
                println("launching coroutine")
                delay(10)
            }
        }
        println("end coroutines $messureForCoroutine")
    }

    println("begin threads")
    // do the same thing with threads. it takes more time  It's supposed to be slower with high values
    val messureForThread = measureTime {
        repeat(times){
            Thread {
                println("launching thread")
                Thread.sleep(10)
            }.join()

        }
    }
    println("end thread $messureForThread")

    // todo check it with page 24
}
