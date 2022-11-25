/*
* Scala provides several type classes and constraints in predef, eg:- Numeric
*/

val intNumT = implicitly[Numeric[Int]]
intNumT.times(2, 3)

val doubleNumT = implicitly[Numeric[Double]]
doubleNumT.times(2.0, 3.0)


//val stringNumT = implicitly[Numeric[String]]
//No implicit Ordering defined for String

/**
 * Numeric types only have a Numeric type class which provides
 * arithmetic operations.
 * There are also implicit constraints like =:= and <:< used in file
 * MethodImposedTypeConstraints.sc
*/
