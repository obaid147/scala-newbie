package scalaadvanced_part1.Generics.Part2

object TypeMembers extends App {
  trait Food { val name: String }
  trait Fruit extends Food

  trait Cereal extends Food

  case class Apple(name: String) extends Fruit

  case class Orange(name: String) extends Fruit

  case class Muesli(name: String) extends Cereal

  /**
   * Just like we can have fields as members of a class, We can also have type as members of class as well.
   * */

  // example

  class demo(x: Int) {
    val theX: Int = x
  }
  new demo(11).theX;//new demo(11).x

  // we cannot access x here because it's a parameter, Same is the rule on TYPES. but below is the solution.
  abstract class FoodBowl {
    type FOOD <: Food//FOOD is abstract but must be subtype of Food. and can be used as a val in and out of the abs class.
    val food: Food
    def eat: String = s"yummy ${food.name}"
  }

  class AppleBowl(val food: Apple) extends FoodBowl {
    type FOOD = Apple // overridden and making FOOD an Apple. F and Apple are same
  }

  val appleBowl: AppleBowl = new AppleBowl(Apple("fiji"))
  val apple1 = appleBowl.food // Accessing parameter food outside of the class
  val apple2: Apple = appleBowl.food

  val apple3: appleBowl.FOOD = appleBowl.food // Now, We can use type outside the FoodBowl
  val apple4: AppleBowl#FOOD = appleBowl.food // Type projecting means it is referring to type FOOD = Apple.



}
