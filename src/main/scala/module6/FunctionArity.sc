val sq: Int => Int = x => x * x // Function1[Int, Int]
val sq1: Function1[Int, Int] = x => x * x

def sqq(x: Int): Int = x * x
// eta expansion,
// functions can be interchanged with def & vice-versa
sqq(2)
sq(2)

val add: (Int, Int) => Int = (a, b) => a + b
val add2: Function2[Int, Int, Int] = (a, b) => a + b

val mul: (Int, Int, Int) => Int = (a, b, c) => a + b + c
val mul2: Function3[Int, Int, Int, Int] = (a, b, c) => a + b + c

//      There is also a Function0
import scala.util.Random

val a = () => 2
a // apply is not called returns function
a() // apply is called returns Int

val makeARandom: () => Double = () => Random.nextDouble()

makeARandom
makeARandom() // equals to apply as it is followed for paren
makeARandom.apply
makeARandom.apply()
// The function above takes no parameters, but is not evaluated
// until () is applied,and is evaluated each time an apply happens

val n = Tuple3(1, 2, 3)
n.productArity // means the length of tuple