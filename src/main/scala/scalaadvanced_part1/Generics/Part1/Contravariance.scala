package scalaadvanced_part1.Generics.Part1
/** 1. Normal Inheritance:-
      Apple is a subtype of Fruit, Fruit is a subtype of Food,
      and (indirectly) Apple is a subtype of Food.......is a subtype of AnyRef .... is a subtype of Ant
      Food <--- Fruit <--- Apple

 * 2. Contravariance:-
      Food is a subtype of Fruit, Fruit is a subtype of Apple, and (indirectly) Food is a subtype of Apple.
      Apple <--- Fruit <--- Food
 */

object Contravariance extends App {
  /** A transport company that transports Food in containers.
   * Company have dedicated containers for specific type of things they transport*/

  trait Food{
    def name: String
    override def toString: String = s"Delivered all ${name}s"
  }
  trait Fruit extends Food

  case class Apple(name: String) extends Fruit
  case class Orange(name: String) extends Fruit


  trait Container[-T]{
    def send(item: T): String
  }

  object AppleContainer extends Container[Apple]{
    override def send(item: Apple): String = s"Sending ${item.name}"
  }
  object OrangeContainer extends Container[Orange]{
    override def send(item: Orange): String = s"Sending ${item.name}"
  }
  object FruitContainer extends Container[Fruit]{
    override def send(item: Fruit): String = s"Sending ${item.name}"
  }
  object FoodContainer extends Container[Food]{
    override def send(item: Food): String = s"Sending ${item.name}"
  }
  object AnyRefContainer extends Container[AnyRef]{
    override def send(item: AnyRef): String = s"Sending ${item.toString}" // cannot use name withSuperType
  }
  object AnyContainer extends Container[Any]{
    override def send(item: Any): String = s"Sending ${item.toString}" // cannot use name withSuperType
  }

  def sendAnApple(container: Container[Apple]): String = {
    container.send(Apple("Kashmiri-Apple"))
    /** Anything that is apple of above in the hierarchy is suitable parameter to this method*/
  }
  println("===============APPLE container===============")
  println(sendAnApple(AppleContainer)) // it works with Container[T],
//  println(sendAnApple(FruitContainer))// type mismatch
  // because Container[Fruit] and Container[Apple] are not related by any type parameter. There is no Variance

  /** now, we will use (-) with type parameter of trait Container[-T]*/
  println(sendAnApple(FruitContainer)) // Fruit is a subtype of Apple
  println(sendAnApple(FoodContainer)) // Food is a subtype of Apple (indirectly)
  println(sendAnApple(AnyRefContainer))
  println(sendAnApple(AnyContainer))

  println("===============ORANGE container===============")
//  println(sendAnApple(OrangeContainer))
/**Orange and Apple do not share the direct link in the hierarchy.
 * So, their wrappers(Container classes) don't share that either.
 * They are still considered different types. */

  def sendAnOrange(container: Container[Orange]): String = {
    container.send(Orange("Some kind of Orange"))
  }

  println(sendAnOrange(OrangeContainer))
  println(sendAnOrange(FruitContainer))
  println(sendAnOrange(FoodContainer))
  println(sendAnOrange(AnyRefContainer))
  println(sendAnOrange(AnyContainer))

}
