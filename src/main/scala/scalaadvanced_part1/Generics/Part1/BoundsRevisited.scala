package scalaadvanced_part1.Generics.Part1

object BoundsRevisited extends App {
  // LEAST UPPER BOUND (LUB)
  val ints: List[Int] = List(1, 2, 3, 4, 5)
  println(ints, " ----------Ints")

  val any_val: List[AnyVal] = true :: ints // ints.::(true) // because AnyVal is supertype of Int & boolean.
  println(any_val)

  val any: List[Any] = "str" :: ints // because Any is supertype of String and Int.
  println(ints, " ----------Ints")
  println(any)

  /**
   * Adding an item to a List will return a new List with a suitable type.
   * The type is the most specific supertype for all items in the new List.
   * This is called the Least Upper Bounds (or sometimes LUB) */
}

/**
 * Fixing the Variance Problems
 */
object EverybodyLUBNow extends App {
  trait Food {
    def name: String
  }

  trait Fruit extends Food

  trait Cereal extends Food

  case class Apple(name: String) extends Fruit

  case class Banana(name: String) extends Fruit

  case class Muesli(name: String) extends Cereal

  case class CornFlakes(name: String) extends Cereal

  case class MixedFoodBowl[+F <: Food](food1: F, food2: F) {
    override def toString: String = s"${food1.name} mixed with ${food2.name}"
  }
  /*case class FoodBowl[+F <: Food](food: F) {
    override def toString: String = s"A bowl of ${food.name}"
    def mix(other: F): MixedFoodBowl[F] = MixedFoodBowl(food, other)
  }// covariant type F occurs in contravariant position in type F of value other def mix(other: F)*/

  case class FoodBowl[+F <: Food](food: F) {
    override def toString: String = s"A bowl of ${food.name}" // cannot use .name if we only use +F

    def mixWith[M >: F <: Food](other: M): MixedFoodBowl[M] = MixedFoodBowl[M](food, other)
  }

  /**
   * Introduce a new type M with lower bounds F, and upper bounds Food.
   * M is a super-type of F (including F itself).
   * M is still a sub-type of Food.
   */

  val mixedFruits: MixedFoodBowl[Fruit] = FoodBowl(Apple("Kashmiri-apples")).mixWith(Banana("southern-bananas"))
  // scala looks for the LUB of Apple and Banana which is Fruit, ie:- we get MixedFoodBowl[Fruit].
  val mixedFruitsFood: MixedFoodBowl[Food] = FoodBowl(Apple("Kashmiri-apples")).mixWith(Banana("southern-bananas"))
  // scala looks for the LUB of Apple and Banana which is Fruit, but F <:Food Fruit is subtype of Food.


  val mixedFood: MixedFoodBowl[Food] = FoodBowl(Apple("Kashmiri-apples")).mixWith(Muesli("Alpen"))
  // scala looks for the LUB of Apple and Muesli that is Food, ie:- we get MixedFoodBowl[Food].

  val mixedCereals: MixedFoodBowl[Cereal] = FoodBowl(Muesli("Alpen")).mixWith(CornFlakes("CornFlakes"))
  // scala looks for the LUB of Apple and Muesli that is Food, ie:- we get MixedFoodBowl[Food].

  val bananaType: MixedFoodBowl[Banana] = FoodBowl(Banana("Banana1")) mixWith Banana("Banana2")
  // LUB here is Banana only...
}
