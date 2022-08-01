abstract class Food {
   def shape: String
   def price: Int
   //so on
}

// We use abstract to enforce method/field implementation
abstract class Fruit extends Food {
  def sweetnessLevel:Int
}

/*abstract class Cereal extends Food {
  def abc: String
}*/

abstract class Veg extends Food {
  def isLeafy:Int
}

class Apple extends Fruit {
  override def sweetnessLevel = 10

  override def shape = "round"

  override def price = 10
}


"hello" == "hello"
"hello" eq "hello"

new String("hello") == new String("hello")
new String("hello") eq new String("hello")

case class Person(name: String, age: Int)

val aamir1 = Person("aamir", 32)
val aamir2 = Person("aamir", 32)

aamir1 == aamir2
aamir1 eq aamir2

