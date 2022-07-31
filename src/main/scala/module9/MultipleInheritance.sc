abstract class Car(name: String){
  def describe(): String
}

abstract class Classic(val vintage: Int, name: String) extends Car(name){
  override def describe(): String
}

trait Convertible extends Car{
  val poweredTop: Boolean
  val name: String
  override def describe(): String
}

case class ClassicConvertible(make: String,
                              model: String,
                              override val vintage: Int,
                              override val poweredTop: Boolean,
                              override val name: String)
                         extends Classic(vintage, name) with Convertible
{
  override def describe(): String = s"Car = $name, make = $make, model = $model, year = $vintage" +
    s"Powered Top = $poweredTop"
}

val n = ClassicConvertible("Ford", "Mustang", 1965, poweredTop = true, "GT-R")

n.describe()