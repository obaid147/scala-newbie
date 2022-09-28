object FunctionVariance1 extends App {
  abstract class Food {
    val name: String
  }

  abstract class Fruit extends Food

  case class Apple(name: String) extends Fruit

  case class Orange(name: String) extends Fruit

  val apple = Apple("Kashmiri-Apple")

  trait Description {
    val describe: String
  }

  case class Taste(describe: String) extends Description

  case class Texture(describe: String) extends Description

  def describeApple(fn: Fruit => Description): Description = fn(apple)

  // passing the Apple to a function that can handle Fruit -- Contravariance
  // juicyFruit produce a kind of Description(Taste). -- Covariant
  val juicyFruit: Fruit => Taste = fruit => Taste(s"${fruit.name} is juicy")
  println(describeApple(juicyFruit))

  val bumpyOrange: Orange => Texture = orange => Texture(s"${orange.name} has bumpy texture")
  //    println(describeApple(bumpyOrange)) // requires Apple => Description found Orange => Texture

  def describeFruit(fn: Fruit => Description): Description = fn(Apple("Fuji"))

  describeFruit(juicyFruit)
  /**The first method parameter should be contravariant to the method passed as an argument*/
}

/**
 * ScalaFunction Variance
trait Function1[-T1, +R]
Scaladoc for Function1
Scaladoc for Function2
Parameters In ==> Contravariant [-T]
Parameters Out ==> Covariant [+T]
No relationship ==> Invariant [T]
They can have more than 1 input Types, Function2[-T1, -T2, +R]
 */

