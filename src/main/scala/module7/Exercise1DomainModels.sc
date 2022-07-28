abstract class Vehicle{
  def name: String
  def desc: Vector[String]

  override def toString: String = s"Vehicle($name)"
  def fullDesc: String = {
    (name +: desc).mkString("\n")
  }
}

case class Car(
              name: String,
              desc: Vector[String] = Vector.empty
              )extends Vehicle

val mustang = Car("Mustang", Vector(
  "1965 Mustang", "Metallic Blue", "302 ci v8"
))
mustang.fullDesc