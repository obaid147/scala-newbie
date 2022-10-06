  // Simple types
  abstract class Food{
    def name: String
  }
  abstract class Fruit extends Food
  // this becomes parametric field as this is a case class
  case class Mango(name: String) extends Fruit
  case class Apple(name: String) extends Fruit

  abstract class Cereal extends Food
  case class Granola(name: String) extends Cereal
  case class Muesli(name: String) extends Cereal

  val fuji = Apple("Fuji")
  val alpen = Muesli("Alpen")

  // Inheritance ---------------
  def eat(f: Food): String = s"${f.name} eaten"
  eat(fuji)
  eat(alpen)

  case class Bowl(food: Food) {
    override def toString = s"A bowl of yummy ${food.name}s"
    def contents = food // lost subTypes
  }

  val fruitBowl = Bowl(fuji)
  val cerealBowl = Bowl(alpen)
  fruitBowl.contents
  cerealBowl.contents
/** fruitBowl.contents & cerealBowl.contents are types of Food
 * We have lost the subtypes Fruits & Cereal*/
