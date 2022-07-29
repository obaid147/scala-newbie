//val l = List(1,2,3)

class Test(val i: Int) {
  def +:(j: Int) = i + j
}

val obj = new Test(1)

obj.+:(11) // OOPS world , left associative

11 +: obj

val l = List(1,2,3)

l.::(22) // Prepend

32 :: l // right associative // Prepend

Nil.::(3).::(11) //chaining or composition

val list1 = List(1,2,3,4)
val list2 = List(5,6,7,9)
val res = list1 ::: list2 // concat

val TwoDList = List(List(1,2,3), List(3,3,4))
val flatted = TwoDList.flatten

/////subtype polymorphism

trait Animal {
  def sound: String
}

class Dog extends Animal {
  override def sound = "bowbow"
}

class Cat extends Animal {
  override def sound = "mew"
}

class Duck extends Animal {
  override def sound = "quack"
}

object PrintSoundsOfAnimal {

  /*  def printSoundOfDog(dog: Dog): Unit = {
      println(dog.sound)
    }
    def printSoundOfCat(cat: Cat): Unit = {
      println(cat.sound)
    }
    def printSoundOfDuck(duck: Duck): Unit = {
      println(duck.sound)
    }*/

  /**
   * A subtype can be passed to any Super type in a method
   * param animal
   */
  def printSound(animal: Animal): Unit = {
    println(animal.sound)
  }

  def printSound2(animal: Animal*): Unit =
    for{
      s <- animal
    } println(s.sound)
}

/*
//PrintSoundsOfAnimal.printSoundOfCat(new Cat)
PrintSoundsOfAnimal.printSoundOfDog(new Dog)
PrintSoundsOfAnimal.printSoundOfDuck(new Duck)*/

PrintSoundsOfAnimal.printSound(new Cat)
PrintSoundsOfAnimal.printSound(new Dog)
PrintSoundsOfAnimal.printSound(new Duck)
PrintSoundsOfAnimal.printSound2(new Cat, new Duck)

val animal1: Animal = new Dog
val animal2: Animal = new Cat
val animal3: Animal = new Duck
//animal1.sound

//--------------------------------------
////Seq hierarchy

def printCollection(superType: Seq[Int]): Unit = {
  println(superType)
}

printCollection(List(1,2,2))
printCollection(Vector(1,2))
printCollection(Array(1,2,2))


//////

var list: List[Int] = List(1,2,3): List[Int]

list = 11 :: list
list.toString

/*val list2: List[Int] = List(1,2,3)

list2 = 11 :: list2
list2.toString*/

//why List is working without being imported??

import scala.annotation.showAsInfix
import scala.collection
import scala.collection._
val s1  = mutable.Set(1,2,3)
s1 += 4
s1


var s2  = immutable.Set(1,2,3)
s2 += 4 // s1 = s1 + 4
s2

/**
 *
 * Int a = 10
 * a += 2  // a = a + 2
 */

var i = 10
i += 19

//dont use var and mutable together.

/*

Map
 */

val t1: (Int, Int) = (1,2)
val t2 = (1 -> 2)
val t3: Tuple2 [Int, Int] = (1, 2)

//Predef is imported automatically in every file
//scala package objects are also imported automatically

var m: Map[Int, Int] = Map(1 -> 2, 3 -> 3)
m + (11 -> 11)

"Ss" -> 11

val rr:Tuple3[Int, String, Boolean] = (1, "str", true)

(1 -> 11) // rewritten to 1.->(11) then expanded to ArrowAssoc
//ArrowAssoc(1).->(11)

//def ->(y: Int): (Int, Int) = (self, y)

implicit class AbcOps(s: String) {
  def containVowels: Boolean = {
    if (s.contains("a") || s.contains("e")) true else false
  }
}
val s: String = "abc" // not an instance of AbcOps but String
s.containVowels

val mapToRiches = Map(
  1 -> "Steal",
  2 -> "profit"
)

for (m <- mapToRiches) {
  println(s"key : ${m._1}, value: ${m._2}")
}

for {
  m <- mapToRiches
}  println(s"key : ${m._1}, value: ${m._2}")

// New concept, when nothing in class body
/*class Person(name: String)

def (person:Person).likes(movie: String): String =
    s"${person.name} likes $movie"

val mary = Person("Mary")*/

class Rational(val n: Int, val d: Int){
  require(this.d != 0)

  override def toString: String = s"R($n/$d)"

  def min(other: Rational): Rational = {
    if ((n.toDouble / d) < (other.n.toDouble / other.d))
      this else other
  }
}

val half = new Rational(1, 2)
val fifth = new Rational(1, 5)
//val smaller1 = half.min(fifth)
val smaller2 = fifth.min(half)