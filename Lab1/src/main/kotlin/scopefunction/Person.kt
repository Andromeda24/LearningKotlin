package scopefunction

class Person {
}

// execute a code in the context of an object.
//
// object.scopefunction { lambdafunction}
// scopfuncion can be let, apply, with

// let good for access or mopdify the object // object.scopefunction { it.} if the lambdahas only one parameter, it is referenced as it
// apply  context object it    return the context itself. used to configurate an oject
// run context object it return the contextobject itself . Useful confgure and access

fun main(){
   val alice = Person
}
