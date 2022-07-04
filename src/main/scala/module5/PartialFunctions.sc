// Not to be confused with partially applied functions
/**
 * A PartialFunction[T, R] extends Function1[T, R] (which is idiomatically written T => R)
 * It can therefore be used in place of any Function1[T, R]
 * Any block of code with case inside of {}s is a Partial Function:
 */
//       Function1[Int, Int]
val pf1: PartialFunction[Int, Int] = {
  case x: Int if x > 0 => x + x
  case x => x * -1
}

val numbs = (-5 to 5).toList

numbs.map(pf1)
 // ------------------------
numbs.map(pf1)
val pf2: PartialFunction[Int, Int] = {
  case x: Int if x > 0 => x + x
}
pf2.isDefinedAt(5)
pf2.isDefinedAt(-5)
//numbs.map(pf2)
// MatchError!
numbs.collect(pf2) // List(2, 4, 6, 8, 10)


//  match and catch use PartialFunctions
/**
numbs match {
  case List() => "It's four!"
}
try 1 / 0
catch {
  case _: Exception => 0
}*/
