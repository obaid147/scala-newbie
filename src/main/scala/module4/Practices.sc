import scala.annotation.tailrec

val res1: Unit = for (i <- 1 to 10) println(i * i)

val res2: Seq[Int] = for (i <- 1 to 10) yield  i  * i

def f(x: Int): Int = x + x
val xx: Seq[Int] = res2.map { elem =>
  f(elem)
}

/*res2 map f
res2.map(f)
val nn: Seq[Int] = res2.map(f(_))*/

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

val flattedList: List[Int] = r.flatten
// line  26 & 28 = line 30
val r2: List[Int] = x.flatMap( i => y.map(j => i + j))

// map + flatten = flatMap
//for - comprehension yield myNewList

val r3: List[Int] = for {
   i <- x // OuterLoop
  j <- y // InnerLoop
} yield i + j

println("===========")
/*val r: Seq[Int] = for {
  i <- 1 to 3
  j <- 1 to 3
} yield i + j*/

println("*****") // Always end in map
val newR1: List[List[List[Int]]] = x.map(i => y.map(j => z.map(k => i * j * k)))
val newR2: List[List[Int]] = x.flatMap(i => y.map(j => z.map(k => i * j * k)))
val newR3: List[Int] = x.flatMap(i => y.flatMap(j => z.map(k => i * j * k)))

val newR4: List[List[List[Int]]] = x.map(i => y.map(j => z.map(k => i * j * k)))
val newR5: List[List[Int]] = newR4.flatten
val newR6: List[Int] = newR4.flatten.flatten
println("*****")

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
 * u have a list of numbers
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
  case head :: tail => length(tail, acc + 1)
  case Nil => acc
}

length(myList).toString + " Length of list"
//reverse(myList)
//lastElementOfList(myList)
//firstElementOfList(myList)
//penultimateElementOfList(myList) //second last element of list
//duplicateItemsInList(myList) // List(3,4,5) --> List(3,3,4,4,5,5)

// 1 reverse
@tailrec
def reverseMyList(xs: List[Int],
                  newList: List[Int]): List[Int] =
  xs match {
    case h :: t => reverseMyList(t, newList.::(h))
    case Nil => newList
  }
reverseMyList(myList, List())

// 2 last element of list
@tailrec
def lastElementOfList(xs: List[Int], last: Int = 0): Int =
  xs match {
    case h :: t => lastElementOfList(t, h)
    case Nil =>  last
}
lastElementOfList((1 to 10).toList)

def firstElementOfList(xs: List[Int]): Int =
  xs match {
    case h :: t => h
    case Nil => -200
  }
firstElementOfList((20 to 25).toList)

// 3 Second last element of list
@tailrec
def secondLastElementOfList(xs: List[Int]): Int =
  xs match {
    case _ if xs.size == 2 => xs.head
    case h :: t => secondLastElementOfList(t)
    case Nil => -200
  }
secondLastElementOfList(List(2))

// 4 duplicateItemsInList

@tailrec
def duplicateItems(xs: List[Int],
                newList: List[Int] = List()): List[Int] = {
  xs match {
    case h :: t => duplicateItems(t, newList.:+(h).:+(h))
    case Nil => newList
  }
}

duplicateItems(myList)

