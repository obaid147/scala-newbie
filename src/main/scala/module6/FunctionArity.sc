val sq: Int => Int = x => x * x // Function1[Int, Int]
val sq1: Function1[Int, Int] = x => x * x

val add: (Int, Int) => Int = (a, b) => a + b
val add2: Function2[Int, Int, Int] = (a, b) => a + b

val mul: (Int, Int, Int) => Int = (a, b, c) => a + b + c
val mul2: Function3[Int, Int, Int, Int] = (a, b, c) => a + b + c

//      There is also a Function0
import scala.util.Random

val makeARandom: () => Double = () => Random.nextDouble()
makeARandom
makeARandom()

// The function takes no parameters, but is not evaluated
// until () is applied,and is evaluated each time an apply happens
