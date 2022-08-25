/**
 * 1.) how to transpose a matrix
 * lists(1,2,3, List(4,4,4), List(9,8,7))
 *  1 2 3     1 4 9
 *  4 4 4 ==> 2 4 8
 *  9 8 7     3 4 7
 *
 *2.) how to multiply a matrix
 *
 *
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
trait MyTransformer2[-A, +B] {
  val transform:A => MyList[B]
}
//class IntToIntTransformer2r extends MyTransformer2[Int, Int] {
//  override def transform(input: Int): MyList[Int] = new ::(input, new EmptyList)
//  /* new ::(1 , new ::(2, new :: (3, new EmptyList)))*/
//}

class NumAndNumMinusOne extends MyTransformer2[Int, Int]{
//  override def transform(input: Int): MyList[Int] = new ::(input, new ::(input-1, new EmptyList))
  val transform: Int => MyList[Int] = input => new ::(input, new ::(input-1, new EmptyList))

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
 // def foreach(f: A => Unit):Unit = ???
  def foreach(f: A => Unit): Unit
  def flatMap[B](transformer: MyTransformer2[A, B]): MyList[B] // ++
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

   override def flatMap[B](transformer: MyTransformer2[A, B]): MyList[B] = {
     // usage of ++

//    transformer transform head
     tail flatMap transformer
     transformer transform head
   }
   override def foreach(f: A => Unit): Unit = {
      f(head)
     tail.foreach(f)
   }

 }
// CLass EmptyList
class EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new Exception("empty.head")
  def tail: Nothing = throw new Exception("empty.tail")
  def isEmpty: Boolean = true
  override def toString: String = "dd"

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = new EmptyList
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = new EmptyList

  override def flatMap[B](transformer: MyTransformer2[Nothing, B]): MyList[B] = new EmptyList

  override def foreach(f: Nothing => Unit): Unit = ()
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
    println()
  /** filter ends*/

  /** flatMap starts*/
//    val p = myIntList.flatMap(new IntToIntTransformer2r)
//    println(p)
    val myIntListFlat: MyList[Int] = new ::(1 , new ::(2, new EmptyList))
    println("-------- flatMap ---------")
    val numMinus1 = myIntListFlat.flatMap(new NumAndNumMinusOne)
    print(numMinus1)
    println()
  /** flatMap ends*/

  /** foreach starts*/
  println("--------foreach--------")
  myIntList foreach println
  /** foreach ends*/


}

// todo: what is case object
// No parameters
// Single Instance



