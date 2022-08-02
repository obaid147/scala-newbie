//You can do similar matches for other collections (but not with cons notation):

def matchSeq1(xs: Vector[Int]): String = xs match {
  case 1 +: 2 +: rest => s"A 1, 2 vector followed by $rest"
  case Vector(a, b, _*) => s"A vector of at least 2 items, starting with $a, $b"
  case Vector(a) => s"A single element vector of $a"
  case Vector() => "The empty vector"
}

/*
+: stands in for ::
Can also use expansion operator _* to match remainder in "constructor" style.
And bindings, so Vector(1, 2, rest @ _*) => is equivalent to 1 +: 2 +: rest =>
This syntax also works for Lists (but with List replacing Vector of course)
 */

matchSeq1(Vector(1, 2, 3, 4))
matchSeq1(Vector(10, 20))
matchSeq1(Vector(10, 20, 30))
matchSeq1(Vector(100))
matchSeq1(Vector().empty)

/*
def matchSeq2(xs: Array[Int]): String = xs match {
  case 1 +: 2 +: rest => s"A 1, 2 vector followed by ${rest.mkString("Array(", ", ", ")")}"
  case Array(a, b, _*) => s"A vector of at least 2 items, starting with $a, $b"
  case Array(a) => s"A single element vector of $a"
  case Array() => "The empty vector"
}

matchSeq2(Array(1, 2, 3, 4))
matchSeq1(Array(10, 20))
matchSeq1(Array(10, 20, 30))
matchSeq1(Array(100))
matchSeq1(Array().empty)*/
