/**
 * So far we have seen Array which is mutable, and just now List which is immutable
 * Both collection types have a TYPE PARAMETER specifying what they hold:
 */
val array1: Array[Int] = Array(1,2,3)
val list1: List[String] = List("scooby", "dooby", "doo")

/**
 * The type parameter is not optional, but can be inferred from the initialization contents:-
 */
val array2 = Array(1,2,3) // Array[Int] is inferred
val list2 = List("scooby", "dooby", "doo") // List[String] is inferred

/**
 * When specifying a collection type in a method parameter (or return parameter), the type parameter must be provided!
 */
def squareRootsOf(xs: List[Int]): List[Double] = // here List is returned back and not separate elements
  for (x <- xs) yield math.sqrt(x)