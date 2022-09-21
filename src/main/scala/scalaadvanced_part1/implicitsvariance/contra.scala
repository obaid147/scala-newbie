package scalaadvanced_part1.implicitsvariance

object Ex extends App {

    trait Animal
    case class Dog(name: String) extends Animal
    case class Cat(name: String) extends Animal

   trait PrettyPrinter[-A] {
     def pprint(a: A): String
   }

  implicit val animalPP: PrettyPrinter[Animal] = new PrettyPrinter[Animal] {
    override def pprint(a: Animal): String = s"Animal: ${a} is a good animal"
  }


  //expose, type class interface
  def prettyPrintAnimal[A](a: A)(implicit pp: PrettyPrinter[A]): String = pp.pprint(a)

  val res: String = prettyPrintAnimal(Dog("Tom"))
  println(res)

 // prettyPrintAnimal[Dog](Dog("Tom"))(dogPP)


/*  var pp1 =new PrettyPrinter[Animal] {
    override def pprint(a: Animal): String = "???"
  }
  var pp2 = new PrettyPrinter[Dog] {
    override def pprint(a: Dog): String = "???"
  }

  pp2 = pp1

  def m(p: PrettyPrinter[Dog]) = ???
  m(pp1)*/
  //PrettyPrinter[Dog] = PrettyPrinter[Animal]
  //DOg <: Animal
  // PP[Animal] <: PP[Dog]
/*  def abc[A](pp: PrettyPrinter[A], a: A) = pp.pprint(a)
  abc(dogPP, Dog("abc"))*/

}

object Ex2 extends App {

  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  trait PrettyPrinter[-A] {
    def pprint(a: A): String
  }

  //type class instance
  implicit val animalPP: PrettyPrinter[Animal] = new PrettyPrinter[Animal] {
    override def pprint(a: Animal): String = s"Animal: $a is a good dog"
  }

  //type clas usage or type class interface
  def prettyPrintAnimal[A](a: A)(implicit pp: PrettyPrinter[A]) = pp.pprint(a)

  //syntax, interface class, extension method
  object PrettyPrinterSyntax {
     implicit class PrettyPrinterOps[A](a: A) {
       def printPretty(implicit pp: PrettyPrinter[A]) = pp.pprint(a)
     }
  }

  import PrettyPrinterSyntax._

  Dog("Tom").printPretty
  // new PrettyPrinterOps(Dog("Tom").printPretty

}

object Ex3 extends App {

  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  // a trait with single parameter method -- type class
  trait PrettyPrinter[-A] {
    def pprint(a: A): String
  }

  // structural or duck typing
  def m1[A <: { def name(): Unit }](a :A): String = {
    s"Animal: name is ${a.name()}is a good dog"
  }

  //expose
  def prettyPrintAnimal[A](a: A)(implicit pp: PrettyPrinter[A]) = pp.pprint(a)

  //prettyPrintAnimal(Dog("Tom"))



}

object Ex11 extends App {

  trait Animal
  case class Dog(name: String) extends Animal
  case class Cat(name: String) extends Animal

  trait PrettyPrinter[-A] {
    def pprint(a: A): String
  }

  //type class instance
  implicit val animalPP  = (a: Animal) => s"Animal: ${a} is a good dog"

  //SAM: single abstract method
  implicit val dogPP: PrettyPrinter[Dog] = (a: Dog) => s"Dog: ${a.name}is a good dog"

  //type clas usage or type class interface
  def prettyPrintAnimal[A](a: A)(implicit pp: PrettyPrinter[A]) = pp.pprint(a)

  //syntax, interface class, extension method
  object PrettyPrinterSyntax {
    implicit class PrettyPrinterOps[A](a: A) {
      def printPretty(implicit pp: PrettyPrinter[A]) = pp.pprint(a)
    }
  }

 // Dog("Tom").printPretty
  // new PrettyPrinterOps(Dog("Tom").printPretty

}

// contravariance, type classes, single abstract method
