import org.scalatest.{FunSuite, Matchers}

trait MyList1[+A]{ //MyList1[A] is invariant in type A

  def head: A
  def tail: MyList1[A]
  def isEmpty: Boolean
  def toString: String

  def filter(f: A => Boolean): MyList1[A]

  def map[B](f: A => B): MyList1[B]

  def foreach(f: A => Unit): Unit

  def ++[B >: A](l: MyList1[B]): MyList1[B]

  def flatMap[B](f: A => MyList1[B]): MyList1[B]

  def zip[B >: A, C](list: MyList1[B])(f: (A, B) => C): MyList1[C]

  def fold[B](x: B)(f: (B, A) => B): B

}

case class ::[A](head: A, tail: MyList1[A]) extends MyList1[A]{
  def isEmpty: Boolean = false
  override def toString: String = {
    if (tail.isEmpty) head.toString else {
      head + ", " + tail.toString
    }
  }

  def filter(f: A => Boolean): MyList1[A] ={
    if(f(head)) ::(head, tail.filter(f))
    else tail.filter(f)
  }

  def fold[B](x: B)(f: (B, A) => B): B = {

    tail.fold(f(x, head))(f)
  }

  def map[B](f: A => B): MyList1[B] = {
      ::(f(head), tail.map(f))
  }

  def foreach(f: A => Unit): Unit = {
    f(head)
    tail.foreach(f)
  }

  def ++[B >: A](myList: MyList1[B]): MyList1[B] = ::(head, tail.++(myList))

  def flatMap[B](f: A => MyList1[B]): MyList1[B] =
    f(head).++(tail.flatMap(f))

  def zip[B >: A, C](list: MyList1[B])(f: (A, B) => C): MyList1[C] = {
    ::(f(head, list.head), tail.zip(list.tail)(f))
  }

}

case object EmptyList extends MyList1[Nothing] {

  def head: Nothing = throw new Exception("empty.head")

  def tail: Nothing = throw new Exception("empty.tail")

  def isEmpty: Boolean = true

  override def toString: String = s"isEmpty = $isEmpty"

  override def fold[B](a: B)(f: (B, Nothing) => B): B = a

  def filter(f: Nothing => Boolean): MyList1[Nothing] =  EmptyList

  def map[B](f: Nothing => B): MyList1[B] = EmptyList

  def foreach(f: Nothing => Unit): Unit = ()

  def ++[B >: Nothing](myList1: MyList1[B]): MyList1[B] = myList1

  def flatMap[B](f: Nothing => MyList1[B]): MyList1[Nothing] = EmptyList

  def zip[B >: Nothing, C](list: MyList1[B])(f: (Nothing, B) => C): MyList1[C] = EmptyList
}

class UnitTesting extends FunSuite with Matchers {
  val intList: MyList1[Int] = ::(1 , ::(2, :: (3, ::(4,  EmptyList))))
  val charList: MyList1[Char] = ::('a', ::('b', ::('c', EmptyList)))
  val stringList: MyList1[String] = ::("obaid" , ::("fayaz", :: ("wani", ::("aamir",  EmptyList))))


  test("Empty foreach should return Unit:- ()") {
    EmptyList.foreach(println) should be(())
  }

  test("Empty ++ should return charList"){
    intList.++(EmptyList) should be (intList)
  }

  test("Empty filter should return EmptyList"){
    EmptyList.filter(x => x) should be (EmptyList)
  }

  test("Empty map should return EmptyList") {
    EmptyList.map(x => x) should be(EmptyList)
  }

  test("Testing filter method"){
    assert(intList.filter(_ > 2) == ::(3, ::(4, EmptyList)), "_ must be greater than 3")
  }

  test("Testing map method"){
    assume(intList.map(_*3) == ::(3, ::(6, ::(9, ::(12, EmptyList)))), "must be ")
  }

  test("++ method"){
    require(intList.fold(0)((x,y) => x+y) == 11, "x must be 10")
  }

  test("Ensuring fold method") {
    intList.fold(0) { (x, y) => x * y } ensuring(_ >= 0, "value cannot be negative")
  }

  test("flatMap method with stringList"){
    stringList.flatMap { // flatMap
      x =>
        ::(x, ::(x.toUpperCase, EmptyList))
    } ensuring(_.tail.head == "obaid".toUpperCase, "Even items should have UpperCases")
  }

  test("concat method test"){
    intList.++(charList) should be (::(1, ::(2, ::(3, ::(4, ::('a', ::('b', ::('c', EmptyList))))))))
  }

  test("Zip method test"){
    assert (intList.zip(stringList) {
      (x, y) => (x, y)
    } != EmptyList, "zipping two lists should not end up empty")
//    should be (::((1,"obaid"), ::((2, "Fayaz"), ::((3, "wani"), ::((4, "aamir"), EmptyList)))))
  }

}
object MainMethod extends App{
  val intList: MyList1[Int] = ::(1 , ::(2, :: (3, ::(4,  EmptyList))))
  val stringList: MyList1[String] = ::("obaid" , ::("fayaz", :: ("wani", ::("sxr",  EmptyList))))
  val charList: MyList1[Char] = ::('a', ::('b', ::('c', ::('d', ::('e', EmptyList)))))

  println(intList.filter(x => x > 2)) // filter

  println(intList.map(x => x*2)) // map

  intList.foreach(println) // foreach

  println(intList.++(charList)) // ++

  println(stringList.flatMap{ // flatMap
    x =>
      ::(x, ::(x.toUpperCase, EmptyList))
  })

  println(intList.zip(stringList){ // zip
    (x, y) => (x, y)
  })

  println(intList.fold(0)((x,y) => x+y))
}

