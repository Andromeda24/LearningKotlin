
fun main() {
    // create a mutable arraylist
    val names = arrayListOf("John","Jane", "Mary")
    println(names)
    println(names.first())
    names.clear()
    //println(names.first()) // list is empty
    println(names.firstOrNull()) // safe call
}
