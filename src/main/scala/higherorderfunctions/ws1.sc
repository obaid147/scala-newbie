import scala.annotation.tailrec

def function1(x: Int, f: Int => Int) = {
   f(x)
}

def double(x: Int): Int = x * x

function1(10, double)


val l = List(1,2,3,4,5,6)

//map and foreach
/**
   A function that take a function as an argument or returns a function as a return values is called a HOF
   map method/function in scala's List class is a higher order function.
   means map will either take a f as an arg or returns f as a return value.
 foreach is also a HOF, but will return Unit always

 */

val list: List[Double] = List(1.2, 2.2)
def sqrtFunction(x: Double) = math.sqrt(x)
val x: List[Double] = for (item <- list) yield sqrtFunction(item)



val result: List[Double] = list.map { item: Double =>
  sqrtFunction(item)
}

//         (1, 2, 3, 4)
def method(list: List[Int], f: Int => Int): List[Int] = {
//  list.map(f)
  list.map { item: Int =>
    f(item) // (1-1, 2-1, 3-1, 4-1)
  }
}
def tempF(x: Int): Int = x - 1
method((1 until 5).toList, tempF)

def method2(list: List[Int], f: Int => Int):Unit = {
   list.foreach(f)
//  list.foreach { item: Int =>
//    f(item)
//  }

}
val printer: Unit = method2((1 until 5).toList, tempF)
// -------------------------------------------

val n1: List[Unit] = List(1,2, 3, 4).map { x =>
  println(x)
}
println("-"*20) // --------------------
val n2: Unit = List(1,2,3,4).foreach { x =>
  println(x)
}

println("-"*20) // --------------------

List((1,false), (2, true)).map { tup =>

}

/**
 *  create a f that gives reverse of a string
 *  then take a list of string and apply above f to each elements of it
 * -------
 *  take a list of strings, if any string is equal to "Scala" then return true
 *  List[String] ==> List[Boolean]
 */

def revString(str:String):String={
  @tailrec
  def rev(str:String,r:String):String={
    if (str == "") r
    else rev(str.tail, str.head + r)
  }
  rev(str,"")
}
val stringList = List("obaid", "fayaz", "wani")

def f(x: String): String = revString(x)

stringList.map{
  item => f(item)
}



