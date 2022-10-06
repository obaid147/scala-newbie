package scalaadvanced_part1.Generics.Part2

object TypeMembers extends App {
  trait Food { val name: String }
  trait Fruit extends Food

  trait Cereal extends Food

  case class Apple(name: String) extends Fruit

  case class Orange(name: String) extends Fruit

  case class Muesli(name: String) extends Cereal

  case class FoodBowl[+F <: Food](food: F) {
    def eat: String = s"yummy ${food.name}"
  }
  val foodBowl: FoodBowl[Apple] = FoodBowl(Apple("fiji"))
  //  val foodInBowl: bowlOfApple.F = bowlOfApple.food // F is a parameter and not a field

  /**
   * Just like we can have fields as members of a class, We can also
   * */


}
