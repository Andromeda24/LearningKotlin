package PrimaryConstructor
// one clas can have ONLY  one primary constructor
// If the parameters doesn't have the word var, are only parameters only accessible in the init block
/*class Account (
    // define the variables. if no default values are poovided, parameter is mandatory in constructor
    // kotling authomatically generates getters and setters
    balance : Double = 0.0,
    name: String = "",
    accountNumber : String,
)
{
    var myBalance
    var myName
    var myAccountNumber
    init {
        println("In init $balance, $accountNumber, $name")
        myBalance = balance
        myName = name
        myAccountNumber = accountNumber
    }
    //override fun toString():String { // fails
    //    return "Account( balance=$balance, name='$name', accountNumber = $accountNumber)"
    //}

    override fun toString():String { // fails
        return "Account( balance=$myBalance, name='$name', accountNumber = $accountNumber)"
    }

}


fun main() {
    val account = Account(balance = 100.0, name="John", accountNumber="12345")

    println (account)
}*/