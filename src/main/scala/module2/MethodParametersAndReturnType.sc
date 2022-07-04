//Let's take a look at a method definition:

def max(x: Int, y: Int): Int = if (x > y) x else y

/**
 * This is fully typed, in that the parameter, and return, types are specified.
 * We can drop the return type, since Scala can infer it
 */

def min(x: Int, y: Int) = if (x < y) x else y

/**
 * As you will see in the worksheet, the method has the same exact type,
   the Int return type is inferred by the compiler
 * However you cannot leave the type annotations off of the parameters,
 * since Scala has no context to infer those from
 */

// Methods with No Return Type

/**
 *Java (and some other languages) have a void keyword, which denotes "no return type"
 * In Scala, every method and variable has a type, there is no void
 * The rough equivalent is Unit, of which there is only one instance: ()
 */
def sayHi(name: String): Unit = println(s"hello $name")

/**
 * Methods resulting in Unit must have side effects in order to be useful (IO is one such side effect)
 * Scala still has procedural syntax, which has the same effect but is deprecated
 */
// ---------------------------------- Methods with no return type

def sayHello(name: String) {
  println(s"hello $name")
}

/**
 *You will get a warning, and IntelliJ will try to correct you, always use :Unit = instead of procedural syntax
 */