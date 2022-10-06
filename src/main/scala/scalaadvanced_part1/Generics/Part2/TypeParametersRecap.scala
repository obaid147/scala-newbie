package scalaadvanced_part1.Generics.Part2

object TypeParametersRecap extends App {

  trait Food {
    val name: String
  }

  trait Fruit extends Food

  trait Cereal extends Food

  case class Apple(name: String) extends Fruit

  case class Orange(name: String) extends Fruit

  case class Muesli(name: String) extends Cereal

  case class FoodBowl[+F <: Food](food: F) {
    def eat: String = s"yummy ${food.name}"
  }

  val fiji = Apple("fiji-")
  val jaffa = Orange("jaffa-")
  val alpen = Muesli("alpen-")

  // compiler knows Apple is the type of FoodBowl, That governs the variance of it.
  val bowlOfApple: FoodBowl[Apple] = FoodBowl[Apple](fiji)
  // we specified the Apple type inside FoodBowl. This allows the compiler to figure out the variance and
  // figure out the subtypes and superTypes of that particular container type.


  val foodInBowl: Apple = bowlOfApple.food
  //  val foodInBowl: bowlOfApple.F = bowlOfApple.food // F is a parameter and not a field
}
