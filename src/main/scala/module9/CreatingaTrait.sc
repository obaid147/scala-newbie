trait Car{
  def color: String
  def describe: String = s"$color car"
}
/**
 * Like a class definition but using trait keyword instead.
 * Cannot take constructor parameters.
 * But can have abstract val's and def's
 * Can also have real behavior and state (e.g. describe could be a def or val)
 * Like an abstract class, you cannot make a new instance unless you supply
    a body
 */
val mustang = new Car {
  val color = "red" // can omit override keyword
} // Car{val color: String} = $anon$1@5baf4194
mustang.describe

// USING TRAITS in a class
class ActualCar(val color: String, val name: String) extends Car

val modelT = new ActualCar("black", "Model T")
modelT.describe

/**
 * All traits have a single superclass as well, by default AnyRef.
 * When you use extends for a trait you are really extending the trait
   superclass and mixing in the trait. E.g. the above is really:
 */
class ActualCar2(val color: String, val name: String) extends AnyRef with Car
Classes can extend only 1 class and multiple traits.

// traits are abstract by default.
// After creating a trait, We get an anonymous class which helps us to create an instance. Line 13
// trait cannot have constructor parameters but can have constructor parameters.
//--------------------------------------------------------------------
// traits are used to simplify DIAMOND Problem.
// When traits are at the same level, they go for their super and not right to left.