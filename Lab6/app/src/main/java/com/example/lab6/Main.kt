package com.example.lab6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //test1()
     //test2()
    testnames()


}

fun test1(){
    runBlocking {
        var job1: Job = launch { //Coroutine code
//This function suspends the coroutine for 1000 milliseconds (1 second).
//It is a non-blocking delay, meaning other coroutines can continue to execute during this delay
            delay(1000L)
            println("Job #1")
        }
        println("from main thread")
    }
    println("end of the main thread")
}

fun test2(){
    runBlocking {
        //run 2 coroutines with the join method.  main task waits for the competition of the jobs to continue
        var job1: Job = launch { //Coroutine code

            delay(1000L)
            println("Job #1")
        }
        var job2: Job = launch { //Coroutine code

            delay(1000L)
            println("Job #1")
        }
        job1.join();
        job2.join()
        println("from main thread")
    }
    println("end of the main thread")
}

fun testnames() {
    runBlocking {
        var job1: Job = launch(CoroutineName("c1")) {
            for (i in 1..3) {
                println("${coroutineContext[CoroutineName]?.name} : $i")
                delay(500)
            }
        }
    }
}

fun createScope(){
    val scope: CoroutineScope = CoroutineScope(Dispatchers.Default)

}
