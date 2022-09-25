package scalaadvanced_part1.Generics.Part1

object Covariance extends App {
  abstract class Vehicle

  case class Car() extends Vehicle

  case class Bike() extends Vehicle

  val vehicleIdentity = (vehicle: Vehicle) => vehicle
  vehicleIdentity(Car())
  vehicleIdentity(Bike())

  /*case class Parking[A](value: A) // Invariance, Parking[Car] has no relation with Parking[Vehicle]

  val carParking: Parking[Vehicle] = Parking[Car](Car())*/

  case class Parking[+A](value: A)

  // because Car is sub type of Vehicle, Parking[Car] is subtype of Parking[Vehicle]
  val carParking: Parking[Vehicle] = Parking[Car](Car())
  //  val carParking1: Parking[Car] = Parking[Vehicle](Car())

  class Parking2[-A](value: A)

  //  val carParking2: Parking[Vehicle] = new Parking2[Car]
  val carParking3: Parking2[Car] = new Parking2[Vehicle](Car())


}

object ContraVeterinary extends App {

  trait Animal

  case class Dog(name: String) extends Animal

  case class Cat(name: String) extends Animal

  /** If Dog is a subtype of Animal, could List[Dog] be considered as subtype of List[Animal]
   * This is the variance question, i.e. whether the subtype relationship can be transferred to generic types. */

  // If the answer is yes, then we can consider generic type covariant.
  // Using + next to type argument

  trait Veterinary[T] {
    def heal(a: T): Boolean
  }

  /** gimme a vet for my dog” and I’ll give you a vet which can heal ANY animal, not just your dog,
   * Your dog will live. */

  val myDog = Dog("Bud")
  val myCat = Cat("Kitty")

  val dogDoctor = new Veterinary[Dog] {
    override def heal(a: Dog): Boolean = true
  }
  dogDoctor.heal(myDog); //dogDoctor.heal(myCat);

  val catDoctor = new Veterinary[Cat] {
    override def heal(a: Cat): Boolean = true
  }
  catDoctor.heal(myCat); //catDoctor.heal(myDog);

  val veterinaryDoctor = new Veterinary[Animal] {
    override def heal(a: Animal): Boolean = true
  }
  veterinaryDoctor.heal(myCat)
  veterinaryDoctor.heal(myDog)
}

object CovariantAnimalCage extends App {

  trait Animal

  case class Cat(name: String) extends Animal

  case class Dog(name: String) extends Animal

  val myCat = Cat("Kitty")
  val myDog = Dog("Tommy")

  trait Cage[-A] {
    def holdAnimal(a: A): String
  }

  val catCage = new Cage[Cat] {
    override def holdAnimal(a: Cat): String = s"This cage holds :- ${a.name}"
  }
  println(catCage.holdAnimal(myCat))

  val animalCage = new Cage[Animal] {
    override def holdAnimal(a: Animal): String = s"This cage holds any animal"
  }
  println(animalCage.holdAnimal(myCat))
  println(animalCage.holdAnimal(myDog))

  case class AnimalCage1[+A](holdAnimal: A)

  //val cats:AnimalCage[Animal] = AnimalCage[Cat](Cat("")) // when AnimalCage[A] required AnimalCage[Animal]
  val cat1: AnimalCage1[Animal] = AnimalCage1[Cat](Cat("")) // when AnimalCage[+A] Works

  class AnimalCage2[-A](value: A)

  //  val cat3: AnimalCage2[Cat] = AnimalCage2[Animal](Cat(""))
  // when AnimalCage[A] or AnimalCage[+A] Required AnimalCage2[Cat]
  val cat2: AnimalCage2[Cat] = new AnimalCage2[Animal](Cat(""))
  // case class with parameter does not work with contravariance

}


