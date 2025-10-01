package higherorderfunction

fun add (number1: Int, number2: Int) = number1+number2
fun sub (number1: Int, number2: Int) = number1-number2

fun operation (op : (Int,Int) -> Int ): Int {
    return op(10,20)
}

fun operation2 (number1: Int, number2: Int, op : (Int,Int) -> Int ): Int {
    return op(number1,number2)
}


fun main(){
    println(operation (::add))

    val x = ::sub
    println(operation (x))

    println(operation2 (5,40,::add))
    println(operation2 (40,30,x))
    println(operation2 (40,30, {number1,number2 -> number1 * number2 } )) // lambda function
// if the lambda is the last parameter, it's possible to write it outside
    val resp = operation2 (40,30) {
            number1,number2 -> number1 * number2
    }
    println(resp)
}