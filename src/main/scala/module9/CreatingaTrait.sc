//trait Car{
//  def color: String
//  def describe: String = s"$color car"
//}
/**
 * Like a class definition but using trait keyword instead.
 * Cannot take constructor parameters.
 * But can have abstract val's and def's
 * Can also have real behavior and state (e.g. describe could be a def or val)
 * Like an abstract class, you cannot make a new instance unless you supply
    a body
 */
//val mustang = new Car {
//  val color = "red" // can omit override keyword
//} // Car{val color: String} = $anon$1@5baf4194
//mustang.describe
//
//// USING TRAITS in a class
//class ActualCar(val color: String, val name: String) extends Car
//
//val modelT = new ActualCar("black", "Model T")
//modelT.describe

/**
 * All traits have a single superclass as well, by default AnyRef.
 * When you use extends for a trait you are really extending the trait
   superclass and mixing in the trait. E.g. the above is really:
 */
//class ActualCar2(val color: String, val name: String) extends AnyRef with Car
//Classes can extend only 1 class and multiple traits.

// traits are abstract by default.
// After creating a trait, We get an anonymous class which helps us to create an instance. Line 13
// trait cannot have constructor parameters but can have constructor parameters.
//--------------------------------------------------------------------
// traits are used to simplify DIAMOND Problem.
trait Car{
  def color: String
  def describe: String = s"$color car"

  override def toString: String = s"$describe"
}

trait Classic extends Car{
  def vintage: Int
  override def describe: String = s"$vintage ${super.describe}"
}

trait Convertible extends Car {
  def poweredTop: Boolean
  override def describe: String = {
    val top = if(poweredTop) "Powered Top" else "convertible"
    s"$top ${super.describe}"
  }
}

class ClassicConvertible(val color: String, val vintage: Int, val poweredTop: Boolean)
                          extends Car with Convertible with Classic

val mustang = new ClassicConvertible("Blue", 1990, true)

/**
 * ClassicConvertible extends Car with Convertible with Classic.
 * It goes from right to left. Starting from
 * Classic then Convertible and then Car and output:-
 * 1990 from Classic trait, Powered Top from Convertible trait, and Blue car from Car trait.
 * This is called linearization.
 */
// ------------------------------ Stacking Traits
// When traits are at the same level, they go for their super and not right to left.