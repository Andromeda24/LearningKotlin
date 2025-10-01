package Objects

class Account {
    // define the variables. default values are mandatory kotling authomatically generates getters and setters
    var balance : Double = 0.0
    var name: String = ""
    var accountNumber : String= ""

    // we can override the toString Method
    override fun toString():String {
        return "Account( balance=$balance, name='$name', accountNumber = $accountNumber)"
    }


}


fun main() {
    val account = Account()
    account.balance=1000.0
    account.name="John"
    account.accountNumber= "12234344"
    println (account)
}