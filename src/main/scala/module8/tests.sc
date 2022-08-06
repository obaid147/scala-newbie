val lots: Any = 100
lots.isInstanceOf[Any]
lots.isInstanceOf[AnyRef]
//  because it is autoboxed in order to give it instanceOf implicitly
lots.isInstanceOf[Int]

val null1: Null = null
val null2: Null = null
null1.isInstanceOf[String]

null1.eq(null2)
null1 == null2
// null1.equals(null2) NullPointerException
val mAndMs = "M&Ms"
val mAndMsRef: AnyRef = mAndMs

mAndMsRef.isInstanceOf[String]
// Because this is a runtime test!

class Candy
class Fudge extends Candy
class Choco extends Candy
val f1 = new Fudge
val f2 = new Fudge
val f3 = new Choco

(f1 == f2) // instance of classes not true
(f1 eq f2)
(f1 != f3)
(f2 ne f3)

val l1 = List(1,2,3)
val l2 = List(1,2,3)
val l3 = List(2,3,4)

(l1 == l2) // lists true
(l1 eq l2)
(l1 != l3)
(l1 ne l3)



