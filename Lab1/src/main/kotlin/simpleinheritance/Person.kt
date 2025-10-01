package simpleinheritance

// open means that can be inherated. by default eavery class and method is final
open class Person (var name: String)
class Student(name : String, var grade: Int) : Person(name)


fun main(){
    val student = Student (name="John", grade = 5)
    println(student.name)
    println(student.grade)
}