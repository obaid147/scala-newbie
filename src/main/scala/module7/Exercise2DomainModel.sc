import scala.collection.mutable
import scala.collection.mutable.ListBuffer

// 1
abstract class RollingStock{
  val name: String
}

// 2
abstract class Car extends RollingStock {
  val carries: String

  def pulled: String = s"$name carrying $carries"

  override def toString: String = pulled
}

class PassengerCar extends Car{
  val name: String = "Passenger Car"

  val carries: String = "people"
}

class CargoCar extends Car{
  val name: String = "Cargo Car"

  val carries: String = "Cargo"
}

// 3
abstract class Engine extends RollingStock{
  def maxCars: Int
  protected val cars: mutable.ListBuffer[Car]
  def pull: String = name + " pulls " + cars.mkString(" and ")
  def add(car: Car): Unit = {

    if (cars.length >= maxCars)
      throw new IllegalStateException("Too many cars for this type of engine")
    cars += car
  }
  override def toString: String = pull
}



class SteamEngine(passengerCar: Car,
                  cargoCar: Car) extends Engine{
  val name = "Steam engine"
  val maxCars = 3
  override protected val cars = ListBuffer(passengerCar,
                                              cargoCar)
}

class DieselEngine(passengerCar: Car,
                   cargoCar: Car) extends Engine{
    val name = "Diesel engine"
    val maxCars = 6
  override protected val cars = ListBuffer(passengerCar)
}

val dieselEngine = new DieselEngine(new PassengerCar,
                                    new CargoCar)

val streamEngine = new SteamEngine(new PassengerCar,
                                    new CargoCar)

dieselEngine.maxCars
streamEngine.maxCars

streamEngine.add(new PassengerCar)
//streamEngine.add(new PassengerCar) too many cars