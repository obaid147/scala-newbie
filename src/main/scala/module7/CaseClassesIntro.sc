import java.time.LocalDate

/**
 * With the case class you get:-
 *
 * 1. Parametric immutable fields by default (no val needed)
 * 2. A nice toString method
 * 3. Working equals and hashCode
 * 4. Factory (apply) method (no new necessary)
 *
 */

case class Car(make: String, model: String, year: Int){
  lazy val isVintage: Boolean = LocalDate.now.getYear - year > 20
}

val mustang = Car("Ford", "Mustang", 1965) // point 4

mustang.make
mustang.model
mustang.year
mustang.isVintage

mustang == Car("Ford", "Mustang", 1965)
mustang == Car("Ford", "Mustang", 1964)

mustang.equals(Car("Ford", "Mustang", 1965))
mustang.eq(Car("Ford", "Mustang", 1965))
