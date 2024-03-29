// Cars and Vehicles
abstract class Vehicle {
  def name: String
  def description: Vector[String]
  override def toString: String = s"Vehicle($name)"
  def fullDescription: String = {
    (name +: description).mkString("\n")
  }
}


case class Car(
                name: String,
                description: Vector[String] = Vector.empty
              ) extends Vehicle
val mustang = Car("Ford Mustang", Vector(
  "1965 Mustang", "Metallic Blue", "302 ci V8"
)) // Vehicle(Ford Mustang)
val datsun = Car("Datsun 280Z", Vector(
  "1982 Datsun 280Z", "Candy Apple Red", "2.8 Liter I6"
)) // Vehicle(Datsun 280Z)
mustang.fullDescription


// parking structure

abstract class VehicleStorage{
  def name: String
  def vehicles: Vector[Vehicle]
  def vehicleCount: Int = vehicles.size

  override def toString: String =
    s"$name with $vehicleCount vehicles"
}

case class ParkingStructure(name: String,
                            vehicles: Vector[Vehicle]
                           )extends VehicleStorage {

  def describeGarage: String = {
    val vehicleString = vehicles.mkString(", ")
    s"$name containing $vehicleString"
  }

  override def toString: String = describeGarage
}

val lot = ParkingStructure(
  "Parking Garage",
  Vector(mustang, datsun)
)
lot.vehicleCount