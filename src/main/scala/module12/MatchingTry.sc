import scala.util.{Success, Failure, Try}


try {

} catch {
  case e =>
}
val bool = false
def methodCall: String = if(bool) "true" else throw new Exception("fool ffailed")
val result: Try[String] = Try(methodCall)

val way1: String = if(result.isSuccess) {
   result.get
} else {
 // val r: Try[String] = result.failed.map { x => x.getMessage}
  result.failed.map { x => x.getMessage}.getOrElse("some other error")
}

val way2 = result  match {
  case Success(x) => x
  case Failure(e) => e.getMessage
}

def apiCall = Try("result, either succcess or failure")
val longCodeBool = false

//verbose, or boilerplate
//anti-pattern
val x: Option[String] = if(longCodeBool) {
  val result = apiCall
  result  match {
    case Success(x) => {
      val xii = 19
      Some(x)
    }
    case Failure(e) => None
  }

} else None

//optimized solution

val x: Option[String] = if(longCodeBool) {
  apiCall.toOption
} else None

//////////////////////////////////////////////////

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