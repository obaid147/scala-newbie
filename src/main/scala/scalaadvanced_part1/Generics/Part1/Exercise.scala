package scalaadvanced_part1.Generics.Part1
/*
object WhyNotReturnContravariant extends App {
  trait Animal
  class Dog(name: String) extends Animal
  class Cat(name: String) extends Animal

  abstract class Vet[-T]{
    def rescueAnimal(): T
  }

  val vet: Vet[Animal] = () => new Cat("Garfield")
  val lassieVet: Vet[Dog] = vet // Vet[Animal] <: Vet[Dog]

  val rescueDog: Dog = vet.rescueAnimal()
  val rescueAnimal: Animal = vet.rescueAnimal()
  val x: Dog = lassieVet.rescueAnimal() // wanted vet for Dog lessie but it's a cat Garfield

}
*/
object Exercise1 extends App {
  class Vehicle

  class Car extends Vehicle
  //  class ElectricCar extends Car
  //  class GasCar extends Car

  case class Dealer[T]() {
    def x[T <: Vehicle](a: T): T = a
  }

  val car1: Dealer[Car] = Dealer[Car]
  val car2: Dealer[Vehicle] = Dealer[Vehicle]
  //car1 & car2 has no relation

}

object Exercise2 extends App {
  trait Vehicle2 {
    def name: String
  }

  case class Car2(name: String) extends Vehicle2

  case class Boat2(name: String) extends Vehicle2

  case class Dealer2[+T <: Vehicle2](contents: T) {
    override def toString: String = s"${contents.name}"
  }

  var car: Dealer2[Vehicle2] = Dealer2[Vehicle2](Car2("CARR"))
  var boat: Dealer2[Boat2] = Dealer2[Boat2](Boat2("Boat"))
  var vehicle2 = Dealer2[Vehicle2](Car2("Vehicle"))
  car = vehicle2
  //  boat = vehicle2

}

object Exercise3 extends App {
  trait Handler[-T] {
    def addHandler(handler: T): Unit

    def allHandlers[M <: T]: Seq[M] // introducing new type
  }

}

/**
 * trait JsonWriter[-T] {
 * def toJson(x: T):String
 * }
 *
 * trait MyList[+A] {
 * def getItem(x:Int):A
 * }
 *
 * trait Model[-T] {
 * def getMOdel: T
 * } */
/*
object Covariance extends App {
  trait Animal

  class Dog extends Animal

  class Cat extends Animal

  // Covariance; If Dogs are also Animals, then is a list of Dogs also a list of Animals?
  class MyList[+T] {
    def head: T

    def tail: MyList[T]

    def add(elem: T): MyList[T]
  }

  val animals: MyList[Animal] = new MyList[Cat]
  val moreAnimals = animals.add(new Dog)

  val garfield = new Cat
  val lassie = new Dog
  val theVet: Vet[Animal] = new Vet[Animal](garfield)
  val lassiesVet: Vet[Dog] = theVet

  class Vet[-T] {
    def heal(animal: T): Boolean = true
  }

  val myDogVet: Vet[Dog] = new Vet[Animal]
  myDogVet.heal(lassie)
  myDogVet.heal(garfield)
}
/**a covariant list cannot have an add(elem: T) method because it breaks type guarantees.*/

object Contravariance extends App {
  trait Animal

  class Dog extends Animal

  class Cat extends Animal

  // Covariance; If Dogs are also Animals, then is a list of Animals also a list of Dogs?
  abstract class Vet[-T] {
    def rescueAnimal(): T // cannot return contravariant type
  }

  val vet: Vet[Animal] = new Vet[Animal] {
    override def rescueAnimal(): Cat = new Cat
  }

  val lassieVet: Vet[Dog] = vet
  val rescueDog: Dog = lassieVet.rescueAnimal()

}

/**
 * Covariant = retrieves or produces T (PRODUCER).
 * Contravariant = acts on, or consumes T (CONSUMER).
 */

object ContraEg extends App {
  case class Animal()
  case class Bonobo() extends Animal

  val foo: Animal => Bonobo = ???
  var bar: Bonobo => Animal = ???
  foo = bar
  bar = foo
}
*/
object ContravariantHar extends App {
  // If Dog <: Animal, does List[Dog] <: List[Animal] ? The Variance Question

  class Animal
  class Dog(name: String) extends Animal

  // If YES, then the type is called COVARIANT.
  val lassie = new Dog("Lassie")
  val germ = new Dog("Germ")
  val husk = new Dog("Husky")

  val anAnimal: Animal = lassie
  val allDogs: List[Animal] = List(lassie, germ, husk)//list of dogs is a list of animals.
  /** Covariance meaning for list type */

  // If NO, then the type is called INVARIANT.
  class MyInvariantList[T]
  //val myDogs: MyInvariantList[Animal] = new MyInvariantList[Dog]
  val myAnimals: MyInvariantList[Animal] = new MyInvariantList[Animal]

  // No or No or No. Quite the opposite -- CONTRAVARIANT
  class MyContravariantList[-T]
  val myDogs: MyContravariantList[Dog] = new MyContravariantList[Animal]

  // contravariant
  trait Vet[-T]{ // [-T <: Animal] restrict T to only those types that are subtype of animals
    def heal(animal: T): Boolean
  }

  def gimmeAVet(): Vet[Dog] = (_: Animal) => true

  val sickDog = new Dog("Buddi")
  val myVet: Vet[Dog] = gimmeAVet()
  myVet.heal(sickDog)

}