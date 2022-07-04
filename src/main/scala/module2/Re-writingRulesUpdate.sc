// What if we update the value in an Array (arrays are mutable so they can
//be updated):
val arr = Array("scooby", "dooby", "doo")
arr(0) = "scrappy"
/**
 * This is re-written to a call to update with the value in parens as the first
    argument, and the value after the equals as the second, so:
*/

arr(1) = "dappy"
// is re-written to
arr.update(1, "dappy")

/**
 *The result of update is defined as Unit so in order to do anything useful, it
  must have a side effect
 */