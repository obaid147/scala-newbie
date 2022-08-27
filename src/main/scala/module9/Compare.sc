
trait CompareAge[T] {

  def older(x: T): T

}
case class Car(name: String, age: Int) extends CompareAge[Car] {

  //private[this] val checkPrivateThisScope = true

   override def older(car: Car) = {
     if(car.age < this.age) car else this
  }

/*  def isPrivate(car: Car) = {
    if(car.checkPrivateThisScope) true else false
  }*/
}

case class Person(name: String, age: Int) extends CompareAge[module10.Person] {

  //private[this] val checkPrivateThisScope = true

  def older(person: module10.Person) = {
    if(person.age < this.age) person else this
  }

  /*  def isPrivate(car: Car) = {
      if(car.checkPrivateThisScope) true else false
    }*/
}

//private[this]

// <: upper-bound ; A is upper bounded by ABC class
// <: here means either ABC or subtype of ABC
def compareAge[A <: CompareAge[A]](item1: A, item2: A) = {
   item1 older item2
}

val car1 =  Car("audi", 1977)
val car2 =  Car("mercedes", 2001)
//car1.older(car2)

compareAge[Car](car1, car2)

val person1 = module10.Person("aamir", 32)
val person2 = module10.Person("obaid", 28)

compareAge[module10.Person](person1, person2)