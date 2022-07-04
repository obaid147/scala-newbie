/**
 * Lambda Expression refers to an expression that uses an anonymous function instead of variable or value.
 * Lambda expressions are more convenient when we have a simple function to be used in one place.
 * These expressions are faster and more expressive than defining a whole function.
 * We can make our lambda expressions reusable for any kind of transformations.
 * It can iterate over a collection of objects and perform some kind of transformation to them.
Syntax:
val lambda_exp = (variable:Type) => Transformation_Expression
 */

val fun1 = (x:Int) => x + x
fun1(2)

val fun2 = (x: Int, y: Int) => x + y
fun2(2, 4)

/**
 * To apply transformation to any collection, we generally use map() function.
 * It is a higher-order function where we can pass our lambda as a parameter in
order to transform every element of the collection according to the definition of our lambda expression.
 */

val l1 = List(2, 3, 4)
val fun3 = l1.map(x => x * x)

// We are passing it as an argument. However, we can make it reusable and may use it with different collections.
val fun4 = (x: Int) => x * x
val l2 = List(10, 11, 12)

val res1 = l1.map(fun4)
val res2 = l2.map(fun4)

// A lambda can also be used as a parameter to a function.
def transform( x:Int, f:Int => Double): Double = f(x)
val res = transform(1, x => 3.14 * x * x)

def trans(list: Seq[Int], f: Int => Double): Seq[Double]
= list.map(f)
val resx = trans(Vector(1, 2, 3), r => 3.14 * r * r)