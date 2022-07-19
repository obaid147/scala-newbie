def toUpper(s:String): String = {
  val arr = s.toCharArray
  for(index <- 0 until s.length) {
    arr(index) = arr(index).toUpper
  }
  new String(arr)
}

def toLower(s:String): String = {
  val arr = s.toCharArray
  for(index <- 0 until s.length) {
    arr(index) = arr(index).toLower
  }
  new String(arr)
}

//this is java code, don't do this, just for example


val s = "string"

toUpper(s)
val s2 = "ssSSSS"
toLower(s2)

def stringOperation(s: String, f: Char => Char):String = {
  val arr = s.toCharArray
  for(index <- 0 until s.length) {
    arr(index) =f(arr(index))
  }
  new String(arr)
}

val toUpperFL = (c: Char) => c.toUpper

stringOperation("sss", toUpperFL)
stringOperation("sss", x => x.toUpper)
stringOperation("sss", x => x.toLower)

/**
 * Code reduce, code quality improve
 * less code means less bugs
 */