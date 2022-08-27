class Pizza{

}

object Pizza{

}

/**
 * companion object and its class can access each other’s private members (fields and methods).
 * This means that the printFilename method in this class will work because it can access the
    HiddenFilename field in its companion object:
 */
// --------------------------------------------------
class SomeClass{
    def printFileName() = {
        println(SomeClass.HiddenFileName)
    }
}
object SomeClass{
    private val HiddenFileName = "/temp/foo.bak"
}

val x = new SomeClass
x.printFileName()

  // -------------------------------------------
// Creating new instance without "new" keyword

class Person1(name: String){
    override def toString: String = name
}
object Person1{
    def apply(name: String): Person1 = {
        new Person1(name)
    }
}

val x = Person1.apply("ABC")
// ----------------------------------------------
// 2
class Person2{
    var name2 = ""
    override def toString: String = name2
}
object Person2{
    def apply(name2: String): Person2 = {
        val p = new Person2
        p.name2 = name2
        p
    }
}

val p = Person2.apply("Obaid")

/**
 * You type something like val p = module10.Person("Fred")
 * The Scala compiler sees that there is no new keyword before module10.Person
 * The compiler looks for an apply method in the companion object of the module10.Person class that matches
   the type signature you entered
 * If it finds an apply method, it uses it; if it doesn’t, you get a compiler error
 */

// Creating multiple constructors

class Animal{
    var name = None
    var age = None

    override def toString: String = s"$name, $age"
}

object Animal{
    def apply(name: String) = {
        val a1 = new Animal
        a1.name = name
        a1
    }
    def apply(name: Option[String], age: Option[Int]) = {
        val a2 = new Animal
        a2.name = name
        a2.age = age
        a2
    }
}

val A1 = Animal.apply(Some("Cat"))
val A2 = Animal(None)
val A3 = Animal.apply(Some("Tiger"), Some(22))
val A4 = Animal.apply(Some("Dog"), None)

A1.name
A1.age
A2.name
A2.age
A3.name
A3.age
A4.name
A4.age