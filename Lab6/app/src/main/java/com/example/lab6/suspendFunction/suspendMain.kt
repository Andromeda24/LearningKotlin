package com.example.lab6.suspendFunction

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {

        launch (){
            myFun()
        }

    }
}

suspend fun myFun(){
    delay(1000)
    println ("Hello World")
    // myFun cannot use delay if is not declared a suspend
}