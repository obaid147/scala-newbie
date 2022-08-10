trait Car{
  def color: String
  def describe: String = s"$color car"
}

class ActualCar(val color: String, val name: String) extends Car

val modelT: ActualCar = new ActualCar("Red", "Model T")
modelT.describe

/**
 * Can still use a trait like an interface to give us
 * polymorphism: */
val car: Car = modelT // modelT is of type ActualCar which in return is of type Car
car.describe

/**
 * We care, because we get free stuff -
 * implement a little, get a lot */

class Demo extends Car with Function1[String, String]{
  override def color = "red"
  // apply method of companion object of Function1
  override def apply(v1: String) = s"$v1 $color"
}
val demo = new Demo
demo("Cherry") // argument for Function1

// andThen is a method we get for free from Function1
val descriptionLength = demo.andThen(_.length)
descriptionLength("Cherry")