import org.scalatest.FlatSpec
import java.util.Date

/*A Scala object represents a class that has exactly one single
instance.
An object is a singleton as a top-level value*/

object Car{ // SINGLETON
  val wheels = 4

  def run: String = {
    val currentDateAndTime: Date =
      new Date(System.currentTimeMillis())
    s"I am a new car running on $currentDateAndTime!"
  }
}
Car.wheels
Car.run
/**The big difference between object and class is that
 * in object, we cannot assign parameters on constructors.
 * Creating a Scala object as a singleton will be most useful
 * for immutable instances and will only exist once.*/

/** A case object inherits all the features of objects,
      and extends them further:
  1. A default implementation of serialization
  2. Pattern matching
  3. Enumeration
  4. A default implementation of toString */
case object Bicycle{
  val wheels = 2

  def run: String = {
    val currentDateAndTime: Date =
      new Date(System.currentTimeMillis())
    s"I am a new bicycle running on $currentDateAndTime!"
  }
}
Bicycle.wheels
Bicycle.run
Bicycle.isInstanceOf[Serializable] // true serializable by default
Car.isInstanceOf[Serializable]

// --------      1        -----Serialization
// A case object is serializable by default
case object ex extends FlatSpec{
  "Bicycle" should "be an instance of Serializable" in {
    assert(Bicycle.isInstanceOf[Serializable])
  }
  "Car" should "not be an instance of Serializable" in {
    assert(!Car.isInstanceOf[Serializable]) // extend serializable
  }
}

// --------   2     -----Pattern Matching
abstract class Vehicle
object Bus extends Vehicle
case object Bike extends Vehicle

def checkVehicle(vehicle: Vehicle): Option[Vehicle] = {
  vehicle match {
    case Bus => Some(Bus)
    case Bike => Some(Bike)
    case _ => None
  }
}
checkVehicle(Bus)
checkVehicle(Bike)
checkVehicle(null)

// --------   2     -----Enumeration

object FlyingObject extends Enumeration{
  val airplane = Value("AP")
  val bird = Value("BD")
  val drone = Value("DE")
}
FlyingObject.airplane.id
FlyingObject.bird.id
FlyingObject.drone.id

object FlyingObjectChangingId extends Enumeration{
  val airplane = Value(10, "AP")
  val bird = Value(4, "BD")
  val drone = Value(7, "DE")
}
FlyingObjectChangingId.airplane.id
FlyingObjectChangingId.bird.id
FlyingObjectChangingId.drone.id

/** MATCH ERROR as no default CASE is there*/
def nonExhaustive(objects: FlyingObject.Value) {
  objects match {
    case FlyingObject.airplane => println("I am an airplane")
    case FlyingObject.bird => println("I am a bird")
  }
}
//nonExhaustive(FlyingObject.drone)

/** We can only extend sealed traits in the same file.
 * The compiler will know all possible subtypes and
 * provide warnings in case pattern matching is not exhaustive.*/

sealed trait FlyingCaseObjects
case object AirplaneCaseObject extends FlyingCaseObjects
case object BirdCaseObject extends FlyingCaseObjects
case object DroneCaseObject extends FlyingCaseObjects

def sealedTraitMatch(flyingObject: FlyingCaseObjects): Unit = {
  flyingObject match {
    case AirplaneCaseObject => println("I am an airplane")
    case BirdCaseObject => println("I am a bird")
  }
}
//sealedTraitMatch(DroneCaseObject)

println(Car)
println(Bicycle) // Nice toString Method
