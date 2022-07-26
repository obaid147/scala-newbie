import java.time.LocalDate

/**
abstract class Car(make: String, model: String, year: Int){
  def isVintage: Boolean
}

val mustang = new Car("Mustang", "Ford", 1965){
  def isVintage = LocalDate.now.getYear - year > 20
}*/
// The year field referenced in the anonymous class is private[this]
// We can make it parametric to get around that: using val for params

abstract class Car(
                  val make: String,
                  val model: String,
                  val year: Int
                  ){
  def isVintage: Boolean
}

val mustang = new Car("Mustang", "Ford", 1965){
  def isVintage = LocalDate.now.getYear - year > 20
}
mustang.isVintage

