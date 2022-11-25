import scala.annotation.implicitNotFound

/*Beyond OneTypeParameter
Remember that type parameters become a part of the overall type.
An implicit parameter simply matches and fills in a unique type.
Therefore, availability of an implicit for multiple types can enforce rules
These rules are orthogonal to the Scala type system and may be used in
combination.
Note that implicit parameter availability is enforced, but does not itself
affect a type it applies to!*/

/** sophisticated eating rules */
trait Food {
  def name: String
}

case class Fruit(name: String) extends Food
case class Cereal(name: String) extends Food
case class Meat(name: String) extends Food

trait Eater {
  def name: String
}

case class Vegan(name: String) extends Eater
case class Vegetarian(name: String) extends Eater
case class Paleo(name: String) extends Eater

/*Ensure correct food may be fed to each of the eaters
* Two type parameters now, Food & Eater*/

@implicitNotFound(msg="Illegal Feeding: No Eats rule from ${EATER} to ${FOOD}")
trait Eats[EATER <: Eater, FOOD <: Food] {
  def feed(food: FOOD, eater: EATER) = s"${eater.name} eats ${food.name}"
}

/*Restrictive feedTo method that requires implicit evidence*/
def feedTo[EATER <: Eater, FOOD <: Food](food: FOOD, eater: EATER)
                                        (implicit ev: Eats[EATER, FOOD]): String = {
  ev.feed(food, eater)
}

val apple = Fruit("Apple")
val alpen = Cereal("Alpen")
val beef = Meat("Beef")

val alice = Vegan("Alice")
val bob = Vegetarian("Bob")
val charlie = Paleo("Charlie")

//feedTo(apple, alice) //could not find implicit value for parameter ev: Eats[Vegan,Fruit]

object VeganRules {
  implicit object veganEatsFruits extends Eats[Vegan, Fruit]
}

object VegetarianRules {
  implicit object vegEatsFruits extends (Vegetarian Eats Fruit)
  implicit object vegEatsCereal extends Eats[Vegetarian, Cereal]
}

object PaleoRules {
  implicit object PaleoEatsFruits extends (Paleo Eats Fruit)
  implicit object PaleoEatsMeat extends Eats[Paleo, Meat]
}

import VeganRules._
feedTo(apple, alice)

import VegetarianRules._
feedTo(apple, bob)
feedTo(alpen, bob)
//feedTo(beef, bob) //no implicit found

import PaleoRules._
feedTo(apple, charlie)
feedTo(beef, charlie)
//feedTo(alpen, charlie) //no implicit found


/** These rules are now compile time enforced behaviour.
 * Vegan cannot eat food other than Fruit.
 * Implicit rules must be imported into the scope.
 * Different implicit rules may be imported to change behaviour.
*/

/*Infix type notation*/
object infixNotation {
  implicit object PaleoEatsFruits1 extends Eats[Paleo, Fruit]

  // parenthesis needed or compiler gets confused...
  implicit object PaleoEatsFruits2 extends (Paleo Eats Fruit)

  // No parenthesis required for type Eats[Paleo, Meat]
  implicit val paleoEatsMeat: Paleo Eats Meat =
    new (Paleo Eats Meat){}
}

def feedTo2[FOOD <: Food, EATER <: Eater](food: FOOD, eater: EATER)
              (implicit ev: EATER Eats FOOD): String = {
  ev.feed(food, eater)
}
