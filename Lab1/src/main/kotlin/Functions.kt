
//the module needs a main function, butother functions canbe created after or before the main

fun add1 (number1: Int,number2: Int): Int {
    return number1 + number2
}

fun addNumbers (number1:Int = 0, number2: Int = 0): Int {
    return number1 + number2
}

fun addAll (vararg numbers: Int): Int {
    var sum = 0;
    for (number in numbers){
        sum += number
    }
    return sum
}

fun main() {
    println (add1(number1=10, number2=20))
    println (addNumbers(number1=10, number2=20))
    println (addNumbers()) //0+0
    println (addNumbers(number1=3)) //3+0
    println (addAll()) //0
    println (addAll(10,20,30)) //10+20+30  OJO

}
