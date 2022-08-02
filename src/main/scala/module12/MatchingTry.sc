import scala.util._

def matchTry(t: Try[_]): String = t match {
  case Success(x) => s"It Worked $x"
  case Failure(e) => s"It failed with $e"
}

matchTry(Try(41/2))
matchTry(Try(40/2))
matchTry(Try(40/0))
// ArithmeticException
// Other core libraries often have pattern match support too, like Future,
//Either, etc.