/** List widens as needed on cons and concatenation.
 * If A extends B then List[A] is a subtype of List[B] */
val l0: List[Int] = 1 :: Nil
val l1 = true :: l0
val l2 = true :: l1
val l3 = 1.2 :: l2

l0.size
l1.size
l2.size
l3.size

val x = List(l0, l1, l2, l3)

def sizeOfList1: List[Int] = for{
  i <- x
} yield i.size
sizeOfList1

def sizeOfList2(xs: List[Any]): Int = xs.size
sizeOfList2(l0)
sizeOfList2(l1)
sizeOfList2(l2)
sizeOfList2(l3)