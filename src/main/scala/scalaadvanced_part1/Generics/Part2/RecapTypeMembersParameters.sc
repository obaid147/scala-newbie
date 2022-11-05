/**
 * Type members available from inside and outside of the class or trait.
 * Type parameters only available from inside of the class.
**/

trait Food{val name: String}
trait Fruit extends Food
trait Cereal extends Food
case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit
case class Oats(name: String) extends Cereal

abstract class FoodBowl[F <: Food](food: F)

/*class AppleBowl(val food: Apple) extends FoodBowl {
  type FOOD = Apple
}*/
// Type parameters become part of the type and must be specified, e.g.
def eatFruit(bowl: FoodBowl[Fruit]) // FoodBowl[Fruit] is not same as FoodBowl[Cereal], type params are not OPTIONAL...

// Type members are enclosed fully in a new type
class FruitBowl extends FoodBowl { type FOOD = Fruit }
def eatFruit(bowl: FruitBowl) // member is already embedded

// Type parameters can have co- and contra-variance, e.g.
trait FruitBowl[-F >: Food] // contravariant lower bound by FOod
trait FruitBowl[+F <: Food] // covariant upper bound by Food

// Type members cannot have variance, and use bounds instead, e.g.
trait FruitBowl { type FOOD <: Food} // Type of FOOD, It must be a subtype of Food.

