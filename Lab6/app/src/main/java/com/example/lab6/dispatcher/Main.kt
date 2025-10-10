package com.example.lab6.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch (Dispatchers.Default){ // heavy
            // Dispatcher determines the thread to be used for the coroutine
            println("Default ${Thread.currentThread()}") // main thread
        }
        //launch (Dispatchers.Main){ // it needs an android app. Default in android
            // Dispatcher determines the thread to be used for the coroutine
        //    println("Main ${Thread.currentThread()}") // main thread
        //}
        launch (Dispatchers.IO){ // light
            // Dispatcher determines the thread to be used for the coroutine
            println("IO ${Thread.currentThread()}") // main thread
        }
    }
}