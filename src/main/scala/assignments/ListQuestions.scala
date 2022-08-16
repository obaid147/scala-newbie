import com.sun.nio.sctp.NotificationHandler

/**
 *
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

trait MyTransformer[-A, +B] { //todo: why -, + //
  def transform(input: A): B // Transforms type A to type B.
}

/*trait MyPredicate[-A]  {

  def check(a: A): Boolean
}

class PositiveFilter extends MyPredicate[Int] {
  def check(x: Int) = x > 0
}*/

class IntToBooleanTransformer extends MyTransformer[Int, Boolean] { // Transform Int to Boolean
  override def transform(input: Int): Boolean = {
     input > 2
  }
}

class IntToIntTransformer extends MyTransformer[Int, Int] { // Transform Int to Boolean
  override def transform(input: Int): Int = input * input
}

abstract class MyList[+A] { //todo: why +
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def toString: String
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
//  def filter(predicate: MyPredicate[A]): MyList[A]
}

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
}

class EmptyList extends MyList[Nothing] {
  def head: Nothing = throw new Exception("empty.head")
  def tail: Nothing = throw new Exception("empty.tail")
  def isEmpty: Boolean = true
  override def toString: String = "ddd"

  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = new EmptyList
}

object ConstructList extends App {

  val o = new EmptyList

  val myList: MyList[Int] = new ::(1 , new ::(2, new :: (3, new ::(4, new EmptyList))))
  println(myList + " -----------> myList")
//  val transformIntToBool = new IntToBooleanTransformer

  val booleanList: MyList[Int] = myList.map(new IntToIntTransformer)

  println(booleanList + " -----------> Transformed myList")
  println()


  val elements = List(List(1, 2, 3), List(4, 5, 6))
  elements.flatMap(x => x.map(y => print(y + " ")))
  println()
  for (i <- elements) {
    for(j <- i){
      print(j)
      print(" ")
    }
    println()
  }

}

// todo: what is case object
// No parameters
// Single Instance


