import scala.language.reflectiveCalls

/**StructuralTypes
Although a different concept, these are often used with existential types, like this:*/
def maxSizeInSeq(xs: Seq[_ <: {def size: Int}]) = xs.map(_.size).max

/**
_ <: {def size: Int}
means any type that defines a method called size,
with no parameters, returning an Int.

Within the maxSizeInSeq method, we only know one thing about the
contents of xs, which is that they have a size method resulting in an Int.
Therefore, we can call that.*/

/**This is often referred to as {static duck typing} in Scala
"If it looks like a duck, walks like a duck, and quacks like a duck, then it probably is a duck."
but it is fully compile time verified still unlike dynamically typed
languages which use duck typing*/

/**
 * Behind the scenes, reflection is used to invoke the .size method,
 * so you should be aware of the performance costs */


// -------------- Tricks withStructuralTypes
/* what the compiler knows and what the run time knows about the types*/
val s: String = "hey"
s.length
val obj: AnyRef = s
//obj.length // AnyRef could be anything, compiler does not know if length is a member of AnyRef.

// REFLECTION API:- we can use it to call length on obj
obj.asInstanceOf[{def length: Int}].length
/*
This literally means "cast to a structural type with one length method
  returning an Int, then call that method".
If the method length is not available, you will receive a reflection
  NoSuchMethodException at runtime.

import scala.language.reflectiveCalls to avoid warnings.
*/

val name = "MyName"
name.charAt(1)
val nameCopy: Any = name
//name1.charAt(1)

nameCopy.asInstanceOf[{def charAt(x: Int): Char}].charAt(1)



trait Food{val name: String}
trait Fruit extends Food
case class Apple(name: String) extends Fruit

val apple: Any = Apple("fiji")
//apple.asInstanceOf[{def length: Int}].length // NoSuchMethodException













