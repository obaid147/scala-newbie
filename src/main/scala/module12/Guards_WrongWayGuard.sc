// Guards
/**
 * Anything on the left of the => is part of the pattern match, anything on the right is what to do.
 * if expressions can be used on the left of the =>:
 * Remember that the first full match stops the attempt going any further.
 */

def describeNumber(x: Int): String = x match {
  case 0                        => "Zero"
  case n if n > 0 && n < 100    => "smallish positive"
  case n if n > 0               => "large positive"
  case n if n > 0 && n < 100    => "smallish negative"
  case _                        => "large negative"
}
describeNumber(-99); describeNumber(99); describeNumber(0)
describeNumber(101); describeNumber(-101)

/**
 * The Wrong Way to Guard
 */
// Remember, guards go on the left of the =>

def badDescribeNumber(x: Int) = x match {
  case 0 => "zero"
  case n => if (n > 0 && n < 100) "smallish positive"
  case n => if (n > 0) "large positive"
  case n => if (n < 0 && n > -100) "smallish negative"
  case _ => "large negative"
} // badDescribeNumber[](val x: Int) => Any!

badDescribeNumber(-99); badDescribeNumber(99); badDescribeNumber(0) // zero
badDescribeNumber(101); badDescribeNumber(-101)