import scala.reflect.ClassTag
import scala.reflect.runtime.universe.{typeTag, TypeTag, typeOf}

/*In addition to type classes you define, or in the core libraries, there are a few
that the Scala compiler can fill in automatically on demand: ClassTag and TypeTag*/


/** Class Tag
 * Class tag inserts a classOf for a generic type when used as an implicit bound:
*/

import scala.reflect._

val s: String = "hi"

classOf[String]

val stringClassTag = classTag[String]



def getClassTag[T: ClassTag](x: T): ClassTag[T] = classTag[T]
/*[T: ClassTag],
ClassTag is an implicit filled be scala compiler (context bound)*/

s.getClass
getClassTag(s)

getClassTag(10).runtimeClass
getClassTag("10").runtimeClass
getClassTag(List("10")).runtimeClass

/*ClassTag context bounds also allow creation of specific array types:*/
getClassTag("").newArray(4) // array of string, size 4
getClassTag(1).newArray(5) // // array of int, size 5



/** Tag is conversation b/w Runtime and compiler*/

/**Class Tag in pattern matching*/
def isA1[T](x: Any): Boolean = x match {
  case _: T => true
  case _ => false
}

//isAt("Str") when using AnyRef
// This should return false but returns compilation error
// the result type of an implicit conversion must be more specific than AnyVal

isA1[Int](1) // Warning
isA1[Int]("") // Warning
// abstract type T is unchecked since it is eliminated by erasure

/** Type erasure means
 * At compile time, isAt[T] it knows what T is
 * But at Runtime, it doesn't know what T is
 * So, it returns true for everything*/

def isA2[T: ClassTag](x: Any): Boolean = x match {
  case _: T => true
  case _ => false
}

isA2[Int](1)
isA2[Int]("str")

// using class tag works but for yop level types only

isA2[List[Int]](List(123))
isA2[List[Int]](List("String")) // should be false

/** Class Tag vs Type Tag*/

val ct = classTag[Map[String, List[Int]]] // knows Map but not String and List[Int]

val tt = typeTag[Map[String, List[Int]]] // knows its a Map of String and List[Int]

/**TypeTag provides most everything the Compiler knows
 * about the type*/

/*Sadly, this is not a simple drop in fix for pattern matching,
but it can be used with effort and guards*/

val theType = tt.tpe // knows its a Map of String and List[Int]
theType.typeArgs


case class Tagged[A](value: A)(implicit val tag: TypeTag[A])

val taggedMap1 = Tagged(Map(1 -> "one", 2 -> "two"))
val taggedMap2 = Tagged(Map(1 -> 1, 2 -> 2))

def taggedIsA[A,B](x: Tagged[Map[A, B]]): Boolean =
  x.tag.tpe match {
    case t if t =:= typeOf[Map[Int, String]] => true
    case _ => false
  }
// =:= to check if specific type is of right type.......
theType.=:=(typeTag[Map[String, List[Int]]].tpe)
theType.=:=(typeTag[Map[String, Int]].tpe)