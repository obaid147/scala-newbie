/**
 * Scala Enumerations are implemented using Path Dependent Types.
*/

object Color extends Enumeration {
  val Red, Green, Yellow, Blue = Value
  // id starts from 0.
  // Value is a method which increments the id everytime we call it.
}

//example
var x = 0
def nextX: Int = {
  x += 1 // x = 1, 2, 3
  x - 1 // return 0 and store in a, b = 2-1, c = 3-1
}
val a, b, c = nextX//each val assignment calls nextX


object Size extends Enumeration {
  val S = Value(1, "Small")
  val M = Value(2, "Medium")
  val L = Value(3, "Large")
  val XL = Value(4, "Extra Large")
}
// By default, Value increments the Int value by 1 on each call.

Color.values // returns ValueSet
Size.values // AssertionError if ID is repeated...
// .values return object.ValueSet eg:- Color.ValueSet

Color.Green.id
Size.S.id

def shirt(color: Color.Value, size: Size.Value): String = {
  s"A nice $color t-shirt of size $size"
}
shirt(Color.Green, Size.M)
//shirt(Size.Green, Color.M)
// Green is not member of Size, M is not member of Color

/**
 * Occasionally useful
 * More limited than Java Enumerations
 * If you need more power, use a sealed trait and
 * case classes/objects
*/

Size.apply(1)
//Size.withName("XL")//NoSuchElementException
Size.withName("Extra Large")
