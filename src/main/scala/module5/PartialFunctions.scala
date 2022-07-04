package module5

object PartialFunctions extends App {

  val pf1: PartialFunction[Int, Int]  = {
    case x: Int if x > 0 => x + x
    case x: Int => x * -1 // -5 * -1
  }
  val fn1: Int => Int = pf1 // upcast

  val numbs = (-5 to 5).toList
  println(numbs.map(pf1))
//  println(numbs.map(fn1))

  val pf2: PartialFunction[Int, Int] = {
    case x: Int if x > 0 => x + x
  } // You get a MatchError thrown if there is no case to handle the input

  /**
   * println(numbs.map(pf2)) match error
   * map may not be safe with a PartialFunction, but collect is:
    */
  println(numbs.collect(pf2))

  //You can also ask PartialFunctions if they are defined for an input:
  println(pf2.isDefinedAt(5))
  println(pf2.isDefinedAt(-5))
}
