package secondaryCostructor

// any secundary Constructor must delegate directly or indirectly to the promary constructor


class Account (
    // define the variables. default values are mandatory kotling authomatically generates getters and setters
    var balance : Double,
    var name: String,
    var accountNumber : String
    )
{
    constructor (accountNumber: String) : this(balance=0.0, name = "Unknown", accountNumber = accountNumber)

    // direct secundary constructor
    constructor (accountNumber: String, name:String): this(balance = 0.0, name = name , accountNumber = accountNumber)
    // indirect secundary constructor
    constructor (accountNumber: String, balance:Double): this (accountNumber)

    override fun toString():String {
        return "Account( balance=$balance, name='$name', accountNumber = $accountNumber)"
    }


}


fun main() {
    val account = Account("2432143214")
    println (account)
}