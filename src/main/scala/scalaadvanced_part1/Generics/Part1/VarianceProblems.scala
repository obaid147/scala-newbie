package scalaadvanced_part1.Generics.Part1

object VarianceProblems extends App {

  trait CombineWith[T] {
    val item: T

    def combineWith(another: T): T
  }

  case class CombineWithInt(item: Int) extends CombineWith[Int] {
    def combineWith(another: Int): Int = item + another
  }

  case class CombineWithString(item: String) extends CombineWith[String] {
    def combineWith(another: String): String = item + another
  }

  val cwi: CombineWith[Int] = CombineWithInt(2)
  println(cwi.combineWith(2))

  val cws: CombineWith[String] = CombineWithString("Hey, ")
  println(cws.combineWith("there!"))

}

/*When Covariant*/
/*object VarianceProblems1 extends App {
  trait CombineWith[+T] {
    val item: T

    def combineWith(another: T): T
  }

  case class CombineWithInt(item: Int) extends CombineWith {
   def combineWith(another: Int): Int = item + another
  }

  val cwo: CombineWith[Any] = CombineWithInt(10)// This is valid because Any is superType
  cwo.combineWith("anyType")
}*/

/**
 * covariant type T occurs in contravariant position in type T of value another
 * def combineWith(another: T): T */

// because it is covariant, we are not allowed to use method params.
