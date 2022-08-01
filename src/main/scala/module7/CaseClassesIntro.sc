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
mustang.hashCode()
mustang.make
mustang.model
mustang.year
mustang.isVintage

mustang == Car("Ford", "Mustang", 1965)
mustang == Car("Ford", "Mustang", 1964)

mustang.equals(Car("Ford", "Mustang", 1965))
mustang.eq(Car("Ford", "Mustang", 1965))


/*class Bicyble {
  def name: String = "hero bicyble"

  override def toString: String = s"Bicyble($name)"
}

val obj = new Bicyble()
obj.hashCode()*/

class Plant(val name: String)

val rose = new Plant("rose")
val sf = new Plant("sf")

case class Animal(name: String)

val cat = Animal("cat")
val dog = Animal("dog")


//same object same content
rose eq rose
cat eq cat
rose == rose
cat == cat


rose eq sf
cat eq dog
rose == sf
cat == dog


// different objects same content in case of case class
Animal("mouse") == Animal("mouse")
Animal("mouse") equals  Animal("mouse")
new Plant("plant1") == new Plant("plant1")

//simple eq always does reference check
Animal("mouse") eq Animal("mouse")
new Plant("plant1") eq new Plant("plant1")

/**
 * if case class if references are different but have
   same contents, == and equals will give true
 */