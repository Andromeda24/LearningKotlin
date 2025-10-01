package interfacedemo

interface Circle {
    val pi: Double // abstract variable
        get()  = 3.14 // this nvalue is NOT stored in any variable
    val radius : Double //abstract property
    fun getArea(): Double = pi * radius * radius // non abstract method
    fun drawCircle() // abstract method

}

class CircleImp(override val radius: Double) : Circle {
    override val pi = 4.5 //Note that anything can be overriden
    override fun drawCircle (){
        TODO ("not yet implemented")
    }
}

fun main(){
    val c:Circle = CircleImp(10.0)
    println (c.getArea())
}