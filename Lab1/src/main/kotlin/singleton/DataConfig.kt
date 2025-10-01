package singleton

object DataConfig {
    fun getConnection(){
        println("Connecting to database...")
    }

}

fun main (){
    DataConfig.getConnection()
}