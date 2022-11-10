/**
 * Scala Enumerations are implemented using Path Dependent Types.
*/

object Color extends Enumeration {
  val Red, Green, Yellow, Blue = Value
  // id starts from 0.
}

object Size extends Enumeration {
  val S = Value(1, "Small")
  val M = Value(2, "Medium")
  val L = Value(3, "Large")
  val XL = Value(4, "Extra Large")
}
// By default, Value increments the Int value by 1 on each call.

Color.values
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