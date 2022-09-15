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

  // Generics ----------------
  case class BowlF[F](contents: F){
  override def toString = s"A bowl of yummy ${contents}s"
  }


  // F as long as F implements Food [F <: Food]
  case class Bowl1[F <: Food](contents: F){
//  override def toString = s"A bowl of yummy ${contents}s"
  override def toString = s"A bowl of yummy ${contents.name}s"
  //  contents.name gives us an error if [F] does not implement [Food]
  //  F <: Food means F is in lower type than Food
  }

  val fruitBowl = Bowl1(fuji)
  val cerealBowl = Bowl1(alpen)
  fruitBowl.contents
  cerealBowl.contents
  // ----- Animal
  abstract class Animal{
    val name: String
    override def toString: String = s"Animal - $name"
  }
  case class Dog(name: String) extends Animal
  val tommy: Dog = Dog("Tommy")
  val dogBowl = BowlF(tommy) // eating dog?

  case class FoodBowl[F <: Food](contents: F){
    override def toString: String = s"A yummy bowl of ${contents.name}s"
  }

  val appleBowl = FoodBowl(fuji)
  val dogBowl1 = FoodBowl(tommy) // tommy is not food

  def holdFruit(food: FoodBowl[Fruit]) = ???


  holdFruit(FoodBowl[Apple](Apple("kashmiri")))
  val b1: FoodBowl[Fruit] = FoodBowl[Fruit](Apple("kashmiri"))
  holdFruit(FoodBowl[Fruit](Apple("kashmiri")))

 // A <: B, FruitBowl[Apple] <: FruitBowl[Fruit] -- covariance