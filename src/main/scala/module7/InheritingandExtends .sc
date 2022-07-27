// Classes extend other classes using the extends keyword:

abstract class Food{
  def name: String
}

abstract class Fruit extends Food
// Fruit must either be abstract or provide name definition

class Orange(val name: String) extends Fruit
// val name: String parametric field in Orange
// provides name override
val orange = new Orange("hady")
// New instances of Orange can be made,
// providing the name to the constructor

orange.name // calling to get name