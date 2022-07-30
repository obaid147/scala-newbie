def api1: String = null
def api2(name: String):String = null

// null is subtype of string

def registration(): Unit = {

  val api1Result = api1
  if(api1Result == null) {
    throw new Exception("")
  } else {
    val api2Result = api2(api1Result)
    if(api1Result == null) {
      throw new Exception("")
    } else {

    }
  }
}


def makeUpperCase(): Option[String] = {
  for {
    res1 <- Option(api1)
    res2 <- Option(api2(res1))
  } yield res1.toUpperCase + res2.toUpperCase
}

makeUpperCase()

/**
  Option : Some, None
 */

val s1: Option[Int] = Some(1)
val s2: Option[Int] = None

def apiCall1(b: Boolean) = if(b) Some(10) else None

val b = true

val result: Option[Int] = apiCall1(b)

//ways to get result from Option

val way1: Int = result match {
  case Some(v) => v
  case None => 0
}


val way2: Int = result.getOrElse(0)
//val way3: Int = result .get //java.util.NoSuchElementException: None.get

val way4 = if(result.isDefined) result.get else 0
val way5 = if(result.nonEmpty) result.get else 0
val way6 = if(result.isEmpty) 0 else result.get

val test1: Any = if(true) Some(10)
val test2: Option[Int] = if(true) Some(10) else None

val correctWay: Option[Int] = Option(1)
//val problemDef = Some(api1) // discouraged

def wrapStringIntoOption(s: String): Option[String] = Option(s + " abc")

val way7: Option[Int] = result.map { r =>
  r + 1
}

val way8: Option[Option[String]] = result.map { r =>
  wrapStringIntoOption(r.toString)
}
way8

val way9: Option[String] = result.flatMap { r =>
  wrapStringIntoOption(r.toString)
}
way9 // way12

val way10: Option[Int] = result.filter(_ > 22)

val way11: Option[Boolean] = result.map(_ > 1)

val way12: Option[String] = result match {
  case Some(v) => wrapStringIntoOption(v.toString)
  case None => Option("0")
}
def processOption(x: Int): String = x.toString

val way14: String = result match {
  case Some(v) => processOption(v)
  case None => ""
}
val way13 = result.fold("0")(processOption)

