import scala.:+
import scala.runtime.Nothing$

/**
 * 1.) how to transpose a matrix
 *
 *  1 2 3
 *  4 4 4
 *  9 8 7
 *
 *2.) how to multiply a matrix
 *
 *
 *3.) we will implement our own list
 */

/** map starts */
trait MyTransformer[-A, +B] { //todo: why -, + //
  def transform(input: A): B // Transforms type A to type B.
}
class IntToIntTransformer extends MyTransformer[Int, Int] { // Transform Int to Boolean
  override def transform(input: Int): Int = input * input
}

class IntToBooleanTransformer extends MyTransformer[Int, Boolean] { // Transform Int to Boolean
  override def transform(input: Int): Boolean = {
    input > 2
  }
}

class IntToStringTransformer extends MyTransformer[Int, String] {
  override def transform(input: Int): String = {
    if(input % 2 == 0) "Fizz" else "Buzz"
  }
}

class DoubleToIntTransformer extends MyTransformer[Double, Int]{
  override def transform(input: Double): Int = input.toInt
}
/** map ends */

/** filter starts */
trait MyPredicate[-A]  {
  def check(input: A): Boolean
}

class CheckEven extends MyPredicate[Int] {
  override def check(input: Int): Boolean = {
    input % 2 == 0
  }
}/** filter ends */

/** flatMap Starts*/
trait MyTransformer2[-A, +B] { //todo: why -, + //
  def transform(input: A): MyList[B] // Transforms type A to type B.
}
class IntToIntTransforme2r extends MyTransformer2[Int, Int] { // Transform Int to Boolean
  override def transform(input: Int):MyList[Int] = new ::(input, new EmptyList)
}
/** flatMap Ends */

// abs class MyList[]
abstract class MyList[+A] { //todo: why +
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def toString: String
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
//  def flatMap[B](transformer: MyTransformer2[A, B]): MyList[B]

}
 // Class ::()
class ::[A](override val head: A, override val tail: MyList[A]) extends MyList[A] {

  def isEmpty: Boolean = false
  override def toString: String = {
    if(tail.isEmpty) head.toString else {
      head + ", " + tail.toString
    }
  }
  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new ::(transformer.transform(head), tail.map(transformer))
  }

   override def filter(predicate: MyPredicate[A]): MyList[A] = {
     if(predicate.check(head)) {
      new ::(head, tail.filter(predicate))
     } else tail.filter(predicate)
   }


//    new ::(predicate.check(head), tail.filter(predicate))

    /*def rec(xs: MyList[A], acc: MyList[Int], f: Boolean): MyList[Int] = xs match {
      case Nil => acc
      case h :: t =>
        if (f) rec(t, acc :+ h, predicate.check(h)) else rec(t, acc, predicate.check(h))
    }
    rec(new::(head, tail), Nil:List[A], predicate.check(head))
  }*/
}
//        if (f(h)) rec(tail, acc :+ head) else rec(tail, acc) on case h :: t=>
// CLass EmptyList
class EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new Exception("empty.head")
  def tail: Nothing = throw new Exception("empty.tail")
  def isEmpty: Boolean = true
  override def toString: String = "dd"

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = new EmptyList
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = new EmptyList
}

object ConstructList extends App {

  val o = new EmptyList

  val myDoubleList: MyList[Double] = new ::(1.1 , new ::(2.1, new :: (3.1, new ::(4.1, new EmptyList))))
  val myIntList: MyList[Int] = new ::(1 , new ::(2, new :: (3, new ::(4, new EmptyList))))
  println(myIntList + " -----------> myList")
  println(myIntList.head + " -----------> head")
  println(myIntList.tail + " -----------> tail")
  println()
//  val transformIntToBool = new IntToBooleanTransformer

  /** map starts*/
    val intToIntList: MyList[Int] = myIntList.map(new IntToIntTransformer)
    val intToBooleanList: MyList[Boolean] = myIntList.map(new IntToBooleanTransformer)
    val intToStringList: MyList[String] = myIntList.map(new IntToStringTransformer)
    val doubleToIntList: MyList[Int] = myDoubleList.map(new DoubleToIntTransformer)
  // empty list returns toString
  println(o.map(new IntToIntTransformer))// new DoubleToIntTransformer // new IntToStringTransformer
    println()
    println(intToIntList + " -----------> Transformed IntList to Int list")
    println()
    println(intToBooleanList + " -----------> Transformed IntList to boolean list")
    println()
    println(intToStringList + " -----------> Transformed IntList to String list")
    println()
    println(doubleToIntList + " -----------> Transformed DoubleList to Int list")
    println()
  /** map ends*/

  /** filter starts*/
    val myEvenFilterList = myIntList.filter(new CheckEven)
    println(myEvenFilterList + "-------------------> FILTER Even")
/** filter ends*/

}

// todo: what is case object
// No parameters
// Single Instance




//


