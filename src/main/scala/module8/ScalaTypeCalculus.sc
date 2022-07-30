/**
 * If type A is a subtype of AnyRef,
 * A + null is A
 * because null is a subtype of all AnyRef's,
 * So A becomes the LUB(Least Upper Bound)
 */

/**
 * For any type A in scala,
 * A + Nothing is A
 * because Nothing is a subtype of everything in scala, So the same
 * reasoning above applies for the LUB
 */

/**
 * If B and C both sub-class A then
 * B + C is A,
 * that being the LUB (the first place the type-hierarchy coverages for B and C as you go up through the
super-classes)
 */
// E.g. practical examples (using an if expression with two return types):
val flag = true
if (flag) 1.0 else () // AnyVal
if (flag) 1.0 // else is not there returns unit
if (!flag) 1.0
if (flag) "hi" // implicit Unit, String + Unit = Any
if (flag) "Hello" else null // String + Null = String
if (flag) 2.0 else null // Double + Null = Any
def fail(msg: String): Nothing =
  throw new IllegalStateException(msg)
if (flag) 2.0 else fail("not 2.0") // Double + Nothing = Double
if (flag) "yo" else fail("no yo") // String + Nothing = String

