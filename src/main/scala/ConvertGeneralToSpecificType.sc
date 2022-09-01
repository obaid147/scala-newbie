/** collect is a partial function which will attempt to narrow the type if it can
 * Collect uses a partial function
 * (if there is a code block with case keyword, it's a partial function).
 * */

val x: Option[Any] = Some("10")

val y: Option[Int] = x.collect{
  case i: Int => i // success
    // if i is not Int, We get None without any errors or exceptions.
}
// Now we can use y instead of x as Option[Int]
