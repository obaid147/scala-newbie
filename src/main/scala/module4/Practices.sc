import scala.annotation.tailrec

val res1: Unit = for (i <- 1 to 10) println(i * i)

val res2: Seq[Int] = for (i <- 1 to 10) yield  i  * i

def f(x: Int) = x + x
res2.map { elem =>
  f(elem)
}

/*res2 map f
res2.map(f)
res2.map(f(_))*/

/*println("====")
res2.foreach { elem =>
 f(elem)
}*/

//(1 to 3).foreach( i => (1 to 3).foreach(j => println(i + j)))
val x: List[Int] = (1 to 3).toList
val y: List[Int] = (1 to 3).toList
val z: List[Int] = (1 to 3).toList
println("===========")
val r: List[List[Int]] = x.map( i => y.map(j => i + j))

val flattedList = r.flatten

val r2: List[Int] = x.flatMap( i => y.map(j => i + j))

// map + flatten = flatMap
//for - comprehension

val r3: List[Int] = for {
   i <- x
  j <- y
} yield i + j

println("===yyy")
/*val r: Seq[Int] = for {
  i <- 1 to 3
  j <- 1 to 3
} yield i + j*/

println("*****")
val newR1: List[List[List[Int]]] = x.map(i => y.map(j => z.map(k => i * j * k)))
val newR2: List[List[Int]] = x.map(i => y.flatMap(j => z.map(k => i * j * k)))
val newR3: List[Int] = x.flatMap(i => y.flatMap(j => z.map(k => i * j * k)))

val newR4: List[List[List[Int]]] = x.map(i => y.map(j => z.map(k => i * j * k)))
val newR5: List[List[Int]] = newR4.flatten
val newR6: List[Int] = newR4.flatten.flatten


val newR7: List[Int] = for {
  i <- x
  j <- y
  k <- z
} yield i * j * k

val xs = List(1,2,4)
val bRes1 = xs.map(elem => if(elem % 2 == 0) true else false)
val bRes3 = xs.map(elem => if(elem % 2 == 0) elem else elem)
val bRes4 = xs.map(elem => if(elem % 2 == 0) elem)
val bRes5 = xs.filter(elem => elem % 2 == 0)

val bRes2 = for {
  i <- xs
  if i % 2 == 0
} yield i

/**
 *
 * u hae a list of numbers
 * filter out even numbers and add 3 to them
 */

val ys = List(1,2,3,4,5,6)

val r1 = ys.filter(_ % 2 == 0).map(_ + 3)

val r2 = for {
  i <- ys
  if i % 2  == 0
} yield i + 3


println("pattern match on list")

val myList = List(1,2,3,4,5,6)

@tailrec
def length(xs: List[Int], acc: Int = 0): Int = xs match {
  case _ :: t => length(t, acc + 1)
  case Nil => acc
}

length(myList)
//reverse(myList)
//lastElementOfList(myList)
//firstElementOfList(myList)
//penultimateElementOfList(myList) //second last element of list
//duplicateItemsInList(myList) // List(3,4,5) --> List(3,3,4,4,5,5)



