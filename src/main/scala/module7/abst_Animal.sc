abstract class Animal{
  def sound: String
  def color: String
}

case class Dog(
                sound: String,
                color: String) extends Animal

val dog = Dog("Woof Woof", "Black")
dog.sound
dog.color
