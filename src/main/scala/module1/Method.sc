def emptyMethod1() = {
  // Side effect
}

def statementMethod() = {
  val x = 10 // Side effect
}

def printString() = {
  println("String") // side effect
}

def addAB(a: Int, b: Int): Int = a + b


def addCD(c: Int, d: Int) = c + d

/**
Return Type can be inferred
but parameter type cannot
**/

//def addEF(e, f): Int = e + f