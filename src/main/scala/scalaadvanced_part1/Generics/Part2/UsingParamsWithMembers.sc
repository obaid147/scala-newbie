trait Food {val name: String}
trait Fruit extends Food
trait Cereal extends Food
case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit
case class Oats(name: String) extends Cereal

abstract class FoodBowl {
  type FOOD <: Food
  val food: FOOD
  def eat: String = s"Yummy ${food.name}"
}

/*
class AppleBowl(val food: Apple) extends FoodBowl {
  type FOOD = Apple
}
*/

object BowlOfFood {
  def apply[F <: Food](f: F) =
    new FoodBowl {
      type FOOD = F
      override val food: F = f
    }
}

BowlOfFood(Apple("Apples")).eat

val bowlOfOats = BowlOfFood(Oats("oats"))
val bowlOfApple = BowlOfFood(Apple("Kashmiri-Apple"))
val bowlOfOrange = BowlOfFood(Orange("Oranges"))

val a: Food = bowlOfApple.food // Apple(Kashmiri-Apple)
val a: Fruit = bowlOfApple.food // Apple(Kashmiri-Apple)
val a: Apple = bowlOfApple.food // Apple(Kashmiri-Apple)

val a1: bowlOfOats.FOOD = bowlOfOats.food // Apple(Kashmiri-Apple)

val a2: String = bowlOfOrange.food.name // String


//val o1: bowlOfOrange.FOOD = bowlOfApple.food


/** --------------- The best of both worlds*/

//Can now define new BowlOfFoods easily:
val appleBowl = BowlOfFood(Apple("Kashmiri"))

/**Anonymous classes are constructed with the correct FOOD type for the F
inferred*/
val a: Apple = bowlOfApple.food
val o: Orange = bowlOfOrange.food

val aa: bowlOfApple.FOOD = Apple("Kashmir")
val oo: bowlOfOrange.FOOD = Orange("Oranges")

/*What is the type of appleBowl?
val appleBowl: FoodBowl{type FOOD = Apple} = BowlOfFood$$anon$1@59220e18
It is a foodBowl but specifically, type FOOD is Apple

* we will see in path dependent types
*/

/** ------------ path dependent types*/
// First we saw that

val a: Apple = appleBowl.food
// is identical too
val a: appleBowl.FOOD = appleBowl.food

/*Remember that appleBowl.FOOD is indistinguishable from Apple by the
compiler (it's an alias)*/

//val o: appleBowl.FOOD = orangeBowl.food
val orange1: bowlOfOrange.FOOD = bowlOfOrange.food
val apple1: bowlOfApple.FOOD = bowlOfApple.food

/*type mismatch is expected here but both are FOODs.
* But they are different types now
*FOOD is only accessible through a containing class or instance.
* It is known as a path dependent type and these are distinct types with
different paths.
*/
// here is an example to explain why they are different
class Foo(x: Int) {val theX: Int = x}
val foo1 = new Foo(10)
val foo2 = new Foo(11)

foo1.theX // can be easily accessed 10
foo2.theX // can be easily accessed 11
/**Just because we access theX using diff instance, We get diff values
 * The same is true for TYPES.
 * SO, when we create a new type in new instance. (object BowlOfFood)
 * That type in a new instance is a diff type / a diff value than the same item
 * in the other instance, They are half dependent bowlOfApple.FOOD*/
// Another example
import scala.collection.{immutable, mutable}
mutable.Set(1,2,3)
immutable.Set(4,5,6)
// Even they both are called sets but we access them using diff paths(package).
// they are diff types, Exactly what we are doing with instances
