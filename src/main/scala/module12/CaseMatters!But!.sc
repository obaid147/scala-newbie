/**
 * Identifiers starting with lower case are treated as variables
 * Identifiers starting with upper case are treated as constants
*/

val MaxLimit = 10
val minLimit = 1

def isALimit(x: Int): Boolean = x match {
  case MaxLimit => true
  case _ => false
}

isALimit(10)
isALimit(3)

// But!
def isALimit1(x: Int): Boolean = x match {
  case MaxLimit => true // constant match works as expected
  case minLimit => true // will not match
  case _ => false
}

isALimit(10) // true //
isALimit(1) // false
isALimit(3) // false