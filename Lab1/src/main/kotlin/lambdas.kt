
fun add(number1:Int, number2:Int) = number1 + number2


fun main() {
//named function
    val addFunction = ::add
    println(add(number1=1, number2=2))
    //println(addFunction(number1=1, number2=2))
    println(addFunction(10, 20))

// Simple lambda expression with named parameters. thte last statement is the return value
    val substractNumbers = { firstNumber: Int, secondNumber: Int ->
        if (firstNumber > secondNumber)
            firstNumber - secondNumber
        else
            secondNumber - firstNumber
    }
    println(substractNumbers(10,5))
    println(substractNumbers(5,50))
    // if the types are explicitily defined before, they are optional at the rigth
    val substractNumbers1:(Int, Int) -> Int = { firstNumber, secondNumber ->
        if (firstNumber > secondNumber)
            firstNumber - secondNumber
        else
            secondNumber - firstNumber
    }

    println(substractNumbers(10,5))
    println(substractNumbers(5,50))

    val myNothingFunction:(String) -> Unit = {name ->
        println ("Hi $name" )    }

    myNothingFunction("Lulu")

    // if the lambda has asingle parameter, it can be referenced with the keyword it


    val square: (Int) -> Int = {
        it * it
    }
    println (square(5))
}