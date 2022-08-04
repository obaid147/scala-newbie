// For more pattern matches GOTO line 56
// Remember a PartialFunction[T, R] extends Function1[T, R]

val pf1: PartialFunction[Int, Int] = {
  case x: Int if x > 0 => x + x
  case x => x * -1
}
lazy val numbs = (-5 to 5).toList
numbs.map(pf1)

//
val r = new PartialFunction[Int, Int] {
  def isDefinedAt(q: Int) = q != 0
  def apply(q: Int) = 12 * q
}
r(10)

val d: PartialFunction[Int, String] = {
  case x if x % 3 == 0 => (x * 3).toString
}
d(12)

// Chaining two partial functions M and m
val M: PartialFunction[Int, Int] =
{
  // using case statement
  case x if x % 5 == 0 => x * 5
}

// Creating Partial function2
val m: PartialFunction[Int, Int] =
{
  // using case statement
  case y if y % 2 == 0 => y * 2
}

// chaining two partial functions using orElse
val r = M orElse m
r(5)
r(4)

// Using collect method
val c: PartialFunction[Int, Int] = {
  case x if x % 5 != 0 => x * 5
}
//val y = List(1, 2, 3).collect(c)
val y = List(1, 2, 3) collect c

// using append on c
val append = (x: Int) => x + 1
//val z = c.andThen(append)
val z = c andThen append
z(4)

/////////////////////////
// Remember a PartialFunction[T, R] extends Function1[T, R]
// This means that a partial function (which is a pattern match) can
// substitute for any Function1

val numbersMap = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

/*numbersMap.map{
  case (1, v) => s"Its 1 with $v"
  case (k, v) => s"Not 1 but ($k, $v)"
}

numbersMap match {
  case x: Map[Int, Int] => s"Its 1 with ${x.head}" // erasure
  //case x: Map[Int, String] => s"Its 1 with ${x.head}"
}*/

/// Partial Function Pattern Match

val pf1: PartialFunction[Map[Int, String], String] = {
  case x => s"$x"
//    numbersMap match {
//      case x => x.map(x => x)
//    }
}
pf1(numbersMap)
pf1(Map(numbersMap.head._1 -> numbersMap.head._2))
