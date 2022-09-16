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

  // ------------------- Generics ----------------
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

  case class FoodBowl[F <: Food](contents: F){ // upperBound
    override def toString: String = s"A yummy bowl of ${contents.name}s"
  }

  val appleBowl = FoodBowl(fuji)
  //  val dogBowl1 = FoodBowl(tommy) // don't eat my dog


  // ------------------Variance ---------------
  def holdFruit(food: FoodBowl[Fruit]): Fruit = {
    //    food is FoodBowl[Fruit]
    //    food.contents is FoodBowl[Fruit]
    //     food.contents.name  is String
    food.contents
  }
    /**FoodBowl can only hold 'Fruit' and cannot hold apple*/

//  holdFruit(FoodBowl[Apple](Apple("kashmiri")))
  val b1: FoodBowl[Fruit] = FoodBowl[Fruit](Apple("kashmiri"))
  holdFruit(FoodBowl[Fruit](Apple("kashmiri")))

  /** FoodBowl[Fruit]
   * THIS IS A wrapper
   * Whenever we see a wrapper
   * Variance comes into picture*/

  def serveToFruitEater(fruitBowl: FoodBowl[Fruit]): String = {
    s"mmmm, those ${fruitBowl.contents.name}s were very good"
  }

  // Specifying type parameter
  val fruitBowl = FoodBowl[Fruit](fuji) // F <: Food
  val cerealBowl = FoodBowl[Cereal](alpen)
  serveToFruitEater(fruitBowl)
//  serveToFruitEater(cerealBowl) type mismatch

  val x: FoodBowl[Apple] = FoodBowl(fuji)
  val y: FoodBowl[Fruit] = FoodBowl[Fruit](fuji)
//  serveToFruitEater(x)
  /**FruitBowl[Fruit] is not same as FruitBowl[Apple]
   * Idea of variance, how these can be related with one another */

  def serveToFoodEater(foodBowl: FoodBowl[Food]): String = {
    s"mmmm, those ${foodBowl.contents.name}s were very good"
  } // FOOD EATER
  val foodBowl: FoodBowl[Food] = FoodBowl[Food](fuji)
  val foodBowl: FoodBowl[Food] = FoodBowl[Food](alpen)
  val fruitBowl = FoodBowl[Fruit](fuji)
//  serveToFoodEater(fruitBowl) type mismatch, even with subtype

  /*Compiler does not know hoe Fruit is related to Food*/
  /** covariance fixes this*/

  

