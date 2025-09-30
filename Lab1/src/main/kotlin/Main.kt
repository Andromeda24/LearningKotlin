package org.ll
fun main() {
    var courseName = "MDP"
    courseName = "MPP" // the variable can changeits value
    //courseName = null // compilation error : Null cannot be a value of a non-null type 'String'.
    // println (courseName.uppercase()) // NULL pointer exception
    // how to make a variable as nullable?
    var car: String? = "Tesla" // the varaible car is nullable
    car = null
    //println (car.uppercase()) // compilation error
    println (car?.uppercase()) // prints null
    //car = "Toyota"
    println (car?.uppercase()) // safe call operator (?)

    // Elvis operator

    print(car?.length?: 0)
    car = null
    print(car?.length?: 0) // if null, use 0 as the value. a way of use a defauls value
    // Not null operation

    print(car!!.length?: 0) // Null POinterexception (Kotling is built over java)
    // use it you' re sure there is No null value

}