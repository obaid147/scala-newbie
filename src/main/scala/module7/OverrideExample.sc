abstract class Machine {
  def Ram: Int
}

class Computer extends Machine {
  def Ram = 10
  // here as this is a case class we didn't need to use override keyword.
}

class Cloth {
  def stuff: String = "cotton"
}

class Nylon extends Cloth {
   override def stuff = "nylon"
  // here as this is a concrete class we need to use override keyword.

}





