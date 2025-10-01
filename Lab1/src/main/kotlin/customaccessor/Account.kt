package customaccessor
// custom getters and setters. used for adding custom validation or make variables private


class Account {
    // define the variables. default values are mandatory kotling authomatically generates getters and setters
    var balance : Double = 0.0
    var name: String = ""
    var accountNumber : String= ""
        // this setter and geter applies to the previous variable (accountNumber)
        set(value) {
            println("setting $field")
            field = value // it is a hidden identifier that referes to accountNumber
            // we canot use the name of the variable (accountNumber) because it creates an infinite recursion...
            //accountNumber = value
        }
        // private get(){
        get() {
            println("getting $field")
            return field
        }
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