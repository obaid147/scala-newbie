abstract class Machine {
  def RAM: Int
}

class COmputer extends Machine {
  def RAM = 10
}

 class Cloth {
  def stuff: String = "cotton"
}

class Nylon extends Cloth {
   override def stuff = "nylon"
}





