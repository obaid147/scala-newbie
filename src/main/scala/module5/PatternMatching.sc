import module10.Person

case class Person(firstName: String, lastName: String)
case class Dog(name: String)


def echoWhatYouGaveMe(x: Any): String = x match {

  // constant patterns
  case 0 => "zero"
  case true => "true"
  case "hello" => "you said 'hello'"
  case Nil => "an empty List"

  // sequence patterns
  case List(0, _, _) => "a three-element list with 0 as the first element"
  case List(1, _*) => "a list beginning with 1, having any number of elements"
  case Vector(1, _*) => "a vector starting with 1, having any number of elements"

  // tuples
  case (a, b) => s"got $a and $b"
  case (a, b, c) => s"got $a, $b, and $c"

  // constructor patterns
  case Person(first, "Alexander") => s"found an Alexander, first name = $first"
  case Dog("Suka") => "found a dog named Suka"

  // typed patterns
  case s: String => s"you gave me this string: $s"
  case i: Int => s"thanks for the int: $i"
  case f: Float => s"thanks for the float: $f"
  case a: Array[Int] => s"an array of int: ${a.mkString(",")}"
  case as: Array[String] => s"an array of strings: ${as.mkString(",")}"
  case d: Dog => s"dog: ${d.name}"
  case list: List[_] => s"thanks for the List: $list"
  case m: Map[_, _] => m.toString

  // the default wildcard pattern
  case _ => "Unknown"
}
///////////////////////////


  // trigger the constant patterns
  println(echoWhatYouGaveMe(0))
  println(echoWhatYouGaveMe(true))
  println(echoWhatYouGaveMe("hello"))
  println(echoWhatYouGaveMe(Nil))

  // trigger the sequence patterns
  println(echoWhatYouGaveMe(List(0,1,2)))
  println(echoWhatYouGaveMe(List(1,2)))
  println(echoWhatYouGaveMe(List(1,2,3)))
  println(echoWhatYouGaveMe(Vector(1,2,3)))

  // trigger the tuple patterns
  println(echoWhatYouGaveMe((1,2)))         // two element tuple
  println(echoWhatYouGaveMe((1,2,3)))       // three element tuple

  // trigger the constructor patterns
  println(echoWhatYouGaveMe(module10.Person("Melissa", "Alexander")))
  println(echoWhatYouGaveMe(Dog("Suka")))

  // trigger the typed patterns
  println(echoWhatYouGaveMe("Hello, world"))
  println(echoWhatYouGaveMe(42))
  println(echoWhatYouGaveMe(42F))
  println(echoWhatYouGaveMe(Array(1,2,3)))
  println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
  println(echoWhatYouGaveMe(Dog("Fido")))
  println(echoWhatYouGaveMe(List("apple", "banana")))
  println(echoWhatYouGaveMe(Map(1->"Al", 2->"Alexander")))

  // trigger the wildcard pattern
  println(echoWhatYouGaveMe("33d"))


/** 1
 * Constant patterns
 * A constant pattern can only match itself.
 * Any literal may be used as a constant.
 * If you specify a 0 as the literal, only an
 * Int value of 0 will be matched. Examples:
 * case 0 => "zero"
 * case true => "true"
 */


/** 2
 * Variable patterns
 * case _ => s"Hmm, you gave me something ..."
 * We don't know what was given to the right side
 * case foo => s"Hmm, you gave me a $foo"
 * Now, we know foo was given
 */

/** 3
 * Constructor patterns
 * case module10.Person(first, "Alexander") => s"found an Alexander, first name = $first"
 * case Dog("Suka") => "found a dog named Suka"
 * case d: Dog => s"dog: ${d.name}" // dog: Fido
 */

/** 4
 * Sequence patterns
 * You can match against sequences like List, Array, Vector, etc.
 * Use the _ character to stand for one element in the sequence,
 * and use _* to stand for “zero or more elements,”
 *
 * case List(0, _, _) => "a three-element list with 0 as the first element"
 * case List(1, _*) => "a list beginning with 1, having any number of elements"
 * case Vector(1, _*) => "a vector beginning with 1 and having any number …"
 */

/** 5
 * Tuple patterns
 * You can also use the _ wildcard if you’re not interested in the value of an element:
 * case (a, b, c) => s"3-elem tuple, with values $a, $b, and $c"
 * case (a, b, c, _) => s"4-elem tuple: got $a, $b, and $c"
 */

/** 6
 * Type patterns
 *  str: String is a typed pattern,
 *  and str is a pattern variable:
 * case str: String => s"you gave me this string: $str"
 */

/** 7
 * Adding variables to patterns
 * variableName @ pattern
 * Below is the example
 */

def addVar2Pattern(x: Any): String = x match {

  case list: List[_] => s"thanks for the List: $list"
//  case list: List(1, _*) => s"thanks for the List: $list"
/** This is an error
* The solution to this problem is to add a variable-binding pattern to the sequence pattern:
*/
  case list @ List(1, _*) => s"$list"
  case Some(x) => s"$x"
  case x @ Some(_) => s"$x"
  case p @ Person(first, "Doe") => s"$p"
}

println(addVar2Pattern(List(1,'a', 2.1, 3)))
println(addVar2Pattern(Some(10)))
println(addVar2Pattern(Some(10)))
println(addVar2Pattern(module10.Person("John", "Doe")))