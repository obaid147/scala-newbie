
// Can still use a trait like an interface to give us polymorphism
trait Car{
  def color: String
  def describe: String = s"$color car"
}

class ActualCar(val color: String, val name: String) extends AnyRef with Car

val modelT = new ActualCar("black", "Model T")

val car: Car = modelT
car.describe

// We care, because we get free stuff -
// implement a little, get a lot

// EG Function1             Function1[String, String]
class Demo extends Car with ((String) => String){
  override def color = "red"

  override def apply(v1: String) = s"$v1 $color"
}

val demo = new Demo
demo("Cherry")
val descriptionLength = demo.andThen(x => x.length)
//val descriptionLength = demo.andThen(_.length)
descriptionLength("Cherry")
// andThen is a method we get for free from Function1