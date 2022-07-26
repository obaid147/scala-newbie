import java.time.LocalDate

abstract class Car(make: String, model: String, year: Int) {
  def isVintage: Boolean =  LocalDate.now.getYear - year < 20
}

//val mustang = new Car("Ford", "Mustang", 1965)
// class Car is abstract cannot be instantiated

val mustang = new Car("Ford", "Mustang", 1965){}
// When you include an empty body, a new
// anonymous concrete class is created

abstract class Car(make: String, model: String, year: Int) {
  def isVintage: Boolean
}
//abstract classes can also have field and method definitions omitted