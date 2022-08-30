abstract class MyList1[+A]{ //MyList1[A] is invariant in type A

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

}

case class ::[A](override val head: A, override val tail: MyList1[A]) extends MyList1[A]{
  override def isEmpty: Boolean = false

  override def toString: String = {
    if (tail.isEmpty) head.toString else {
      head + ", " + tail.toString
    }
  }

  def filter(f: A => Boolean): MyList1[A] ={
    if(f(head)) ::(head, tail.filter(f))
    else tail.filter(f)
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

  override def toString: String = "dd"

  def filter(f: Nothing => Boolean): MyList1[Nothing] =  EmptyList

  def map[B](f: Nothing => B): MyList1[B] = EmptyList

  def foreach(f: Nothing => Unit): Unit = ()

  def ++[B >: Nothing](myList1: MyList1[B]): MyList1[B] = myList1

  def flatMap[B](f: Nothing => MyList1[B]): MyList1[Nothing] = EmptyList

  def zip[B >: Nothing, C](list: MyList1[B])(f: (Nothing, B) => C): MyList1[C] = EmptyList
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
}

