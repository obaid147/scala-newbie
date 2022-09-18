package scalaadvanced_part1.Generics.Part1

object Invarinace_Covariance extends App{

  abstract class Food {
    def name: String
  }

  abstract class Fruit extends Food
  abstract class Cereal extends Food

  case class Apple(name: String) extends Fruit
  case class Oats(name: String) extends Cereal
  case class Kelloggs(name: String) extends Cereal

  val apple: Apple = Apple("kashmiri-apple")
  val oats: Oats = Oats("oat")
  val kelloggs: Kelloggs = Kelloggs("kelloggs")


  // ------------------- Generics ----------------

  case class SimpleBowl[F](contents: F) {
    override def toString = s"A bowl of yummy ${contents}s" // cannot access contents.name here
    //  contents.name gives us an error if [F] does not implement [Food]
  }
//  println(SimpleBowl(kelloggs))

  case class Bowl1[F <: Food](contents: F) {  // F as long as F implements Food --> ([F <: Food])
    override def toString = s"A bowl of yummy ${contents.name}s"
    //  F <: Food means F is in lower type than Food
  }

  val fruitBowl1 = Bowl1(apple); val cerealBowl1 = Bowl1(oats); val kelloggsBowl1 = Bowl1(kelloggs)

  // ----- Animal
  abstract class Animal {
    val name: String
    override def toString: String = s"Animal - $name"
  }
  case class Dog(name: String) extends Animal
  val tommy: Dog = Dog("Tommy")
  val dogBowl = SimpleBowl(tommy)  // eating dog? This should NOT happen
// so, use anyBowl[Type](content]. SimpleBowl[Fruit](tommy) mismatch error.

  // ------------------Variance ---------------
  case class FoodBowl[F <: Food](contents: F) { // upperBound
    override def toString: String = s"A yummy bowl of ${contents.name}s"
  }
//  val dogBowl = FoodBowl(tommy) // now we are pleased by the power of the scala type System (UpperBounds)

  /** FoodBowl[Fruit]
   * THIS IS A wrapper
   * Whenever we see a wrapper
   * Variance comes into picture */

  def serveToFruitEater(fruitBowl: FoodBowl[Fruit]): String = {
    s"mmmm, those ${fruitBowl.contents.name}s were very good"
  }

  // Specifying type parameter
  val fruitBowl2 = FoodBowl[Fruit](apple) // F <: Food
  val cerealBowl2 = FoodBowl[Cereal](oats)
  serveToFruitEater(fruitBowl2)
  //  serveToFruitEater1(cerealBowl) type mismatch

  // case class FoodBowl[F <: Food](contents: F)
  val x: FoodBowl[Apple] = FoodBowl(apple)
  val y: FoodBowl[Fruit] = FoodBowl[Fruit](apple)
//    serveToFruitEater1(x)

  /** FruitBowl[Apple] is not same as FruitBowl[Fruit]
   * Idea of variance,
   * how these can be related with one another when they are sub/superTypes of 1 another */

  // ------ Invariance
  def serveToFoodEaterInvariance(foodBowl: FoodBowl[Food]): String = { // FOOD EATER
    s"mmmm, those ${foodBowl.contents.name}s were very good"
  }

  val foodBowl1: FoodBowl[Food] = FoodBowl[Food](apple)
  val foodBow2: FoodBowl[Food] = FoodBowl[Food](oats)
  val fruitBowl3 = FoodBowl[Fruit](apple)
  //serveToFoodEater2(fruitBowl3) //type mismatch, even with subtype

  /**Compiler does not know how Fruit is related to Food.
   * covariance fixes this */


    // ----------- Covariance --------------------------------
    // A <: B, FruitBowl[Apple] <: FruitBowl[Fruit] -- covariance +

    case class MyFoodBowl[+F <: Food](contents: F) {
      override def toString: String =
        s"A yummy bowl of ${contents.name}s"
    }

    def serveToFoodEaterCovariance(foodBowl: MyFoodBowl[Food]) =
      s"mmmm, I really liked that ${foodBowl.contents.name}"

    val myFoodBowl: MyFoodBowl[Food] = MyFoodBowl[Food](kelloggs)

    val myFruitBowl: MyFoodBowl[Fruit] = MyFoodBowl[Fruit](apple)
    val myCerealBowl: MyFoodBowl[Cereal] = MyFoodBowl[Cereal](oats) // also works

    val myAppleBowl: MyFoodBowl[Apple] = MyFoodBowl[Apple](apple) // also works
    val myOatsBowl: MyFoodBowl[Oats] = MyFoodBowl[Oats](oats)
    val myKelloggsBowl: MyFoodBowl[Kelloggs] = MyFoodBowl[Kelloggs](kelloggs)

    println(serveToFoodEaterCovariance(myFoodBowl))

    println(serveToFoodEaterCovariance(myFruitBowl))
    println(serveToFoodEaterCovariance(myCerealBowl))

    println(serveToFoodEaterCovariance(myAppleBowl))
    println(serveToFoodEaterCovariance(myOatsBowl))
    println(serveToFoodEaterCovariance(myKelloggsBowl))

  /*
  this is now considered as subtype of FoodBowl[Food]
  because we defined Type F with + sign, which is the
  covariant type.
  It defines that relation between FoodBowl based on type parameter.
  */

}
