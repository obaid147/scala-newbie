import java.time.LocalDate

// ---- val override def
abstract class Car(
                  val make: String, val model: String, val year: Int
                  ) {
  def isVintage: Boolean
}

val mustang = new Car("Mustang", "Ford", 1965){
  val isVintage: Boolean = LocalDate.now.getYear - year > 20
}
mustang.isVintage

// ----- val override val
abstract class Person(val name: String, val age: Int){
  val isAdult: Boolean
}

val person = new Person("Obaid", 28){
  val isAdult: Boolean = age > 18
}
person.isAdult