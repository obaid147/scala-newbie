abstract class Vehicle(val name: String, val age: Int){
  override def toString: String =
    s"$name, $age years old."
}

class Car(
         override val name: String,
         val make: String,
         val model: String,
         override val age: Int
         ) extends Vehicle(name, age)
{
  override def toString: String =
    s"a $make, $model, named ${super.toString}"
}

val mustang = new Car("Sally", "Ford", "Mustang", 50)

// Must override the vals from the super-class with the same name
// Constructor parameters are passed on through the extends
// super calls in methods call into the super-class
// -------------------------------------------------------------------------

class Car1(
          name: String,
          val make: String,
          val model: String,
          age: Int
          )extends Vehicle(name, age){
  override def toString: String =
    s"a $make, $model, named ${super.toString}"
}

val santro = new Car1("Santro", "Hyundai", "Hatchback", 30)

// If the override val feels wierd, you can just make those field private[this]
// They will still be public because of the super-class definition
// But you can't make them vals in Car without an override
