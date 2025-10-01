package Requestdto

data class Requestdto(
    val name:String,
    val age: Int
)

fun main(){
    val  requestdto = Requestdto(name= "john", age = 20)
    println(requestdto)
    println(requestdto.name)
    println(requestdto.age)

    val request2 = requestdto.copy()
    println(request2)
    println(request2.name)
    println(request2.age)

    println(requestdto.equals(request2))  // objects are equal
    println(requestdto == request2) // objects are equal
    println(requestdto === request2) // the reference is not the same



    val request3 = requestdto.copy(name = "Jane")
    println(request3)
    println(request3.name)
    println(request3.age)


    println(requestdto.equals(request3))  // objects are not equal
    println(requestdto == request3) // objects are not equal
    println(requestdto === request3) // the reference is not the same

}
