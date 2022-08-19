/**
 * flatMap is a combination of map and flatten method.
 * flatMap() method is identical to the map() method,
 * but the only difference is that in flatMap the inner
 * grouping of an item is removed and a sequence is generated.
 */

val name = Seq("Nidhi", "Singh")
//let’s apply map() and flatten() on the stated sequence.

// Applying map()
val result1 = name.map(_.toLowerCase)
//List(nidhi, singh)

// Applying flatten() now,
val result2 = result1.flatten
//List(n, i, d, h, i, s, i, n, g, h)   This is the final result
// -----------------------------------------------------

//let’s apply flatMap() directly on the given sequence.

name.flatMap(_.toLowerCase)
//List(n, i, d, h, i, s, i, n, g, h)
/**
 * So, we can see here that the output obtained in both the cases is same therefore,
 * we can say that flatMap is a combination of map and flatten method.
 */

val list = List(2, 3, 4)

def f(x: Int) = List(x-1, x, x+1)

val res = list.flatMap(y => f(y))

//------------------More Operations-----------------------

def toInt(s: String): Option[Int] = {
  try{
    Some(Integer.parseInt(s.trim))
  }catch{
    case _: Exception => None
  }
}
toInt("Obaid")
toInt("123")

val strings: Seq[String] = Seq("1", "2", "foo", "3", "bar")

strings.map(toInt)// toInt parameters is a Seq of Strings now...
strings.map(x => toInt(x)) // syntactic sugar above
strings.flatMap(toInt) // take out type from Some()
strings.flatMap(toInt).sum

// using map and flatten to do the same
val mapper = strings.map(toInt)
mapper.flatten
mapper.flatten.sum

//------ Method that takes single Int parameter and returns 3 ints.
val l = List(1 ,2, 3, 4, 5)
def g(v: Int) = List(v-1,v, v+1)
l.map(g)
l.map(g).flatten
l.flatMap(g)

//---
val map = Map(1 -> "one", 2 -> "two", 3 -> "three")
1 to map.size flatMap map.get
1 to map.size map map.get
1 to map.size flatMap(map.get(_))

// --------
val chars = 'a' to 'z'

val perms = chars flatMap { a =>
  chars flatMap{ b =>
    if(a != b) Seq("%c%c".format(a, b))
    else Seq()
  }
}
