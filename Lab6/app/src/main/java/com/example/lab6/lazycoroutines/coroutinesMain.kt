package com.example.lab6.lazycoroutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        //lazy launch.
        // THE JOBS ONLY START WHEN CALLED .JOIN() OR .start()
        var job1: Job = launch (start = CoroutineStart.LAZY){ //Coroutine code
            println("Job #1 start")
            delay(1000L)
            println("Job #1 ends")
        }
        var job2: Job = launch (start = CoroutineStart.LAZY){ //Coroutine code

            println("Job #2 starts")
            delay(1000L)
            println("Job #2 ends")
        }
        job1.join();
        job2.join()
        println("from main thread")
    }
    println("end of the main thread")
}