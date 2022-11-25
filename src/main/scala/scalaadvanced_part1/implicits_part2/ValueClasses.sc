implicit case class TimesInt(i: Int) extends AnyVal {
  def times(fn: => Unit): Unit = {
    var x = 0
    while (x < i) {
      x += 1
      fn
    }
  }
//  class X
//  object Y
//  trait Z
//  val a = 100
//  var b = "Hi"
}

5 times{ println("Value Classes")}

/** Implicit extension classes are very useful and easy.
 * However they still require a wrapping at runtime into the target class.
 * Implicit value classes avoid this overhead.
 *
 * Must have just one public parametric field and no other state(val's, vars, Nested{classes, traits, objects} ), and extend AnyVal.
 *
 * It must have a single, public val parameter, use case classes.
 *
 * Methods (like times) are now generated as static methods, no runtime wrapping required.
*/
