package enum

enum class Coffee {
    AMERICANO, LATTE, EXRESO, CAPUCCINO
}
fun main() {
    println(Coffee.CAPUCCINO)  //CAPUCCINO
    println(Coffee.valueOf("CAPUCCINO")) //CAPUCCINO
//println(Coffee.valueOf("CAPUCCCCCCCINO")) //IllegalArgumentException
    println(Coffee.valueOf(readlnOrNull()?: "CAPUCCINO"))


}