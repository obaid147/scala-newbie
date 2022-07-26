import scala.annotation.tailrec
  //       Function0 without parameters
@tailrec
def fruitLoop(pred: () => Boolean)(body: () => Unit): Unit = {
  if (pred()) {
    body()
    fruitLoop(pred) (body)
  }
}

var x = 0
fruitLoop(() => x < 5) { () =>
  println(x * x)
  x += 1
}
// This looks kind of like a while loop, except for
// those () => bits when we call it

//             By-name Functions
@tailrec
def fruitLoop1(pred: => Boolean)(body: => Unit): Unit = {
  if (pred) {
    body
    fruitLoop1(pred) (body)
  }
}

var y = 0
fruitLoop1(y < 5) {
  println(y * y)
  y += 1
}

/**
 * To provide nicer syntax at the call site,
 * Scala has by-name functions as an alternative to Function0
 * We have now constructed a loop syntactically identical to while
 * The by-name function is evaluated without ()s, "by-name"
 * only (except if you call another method expecting a by-name)
 * By-names are easy to get wrong, beware! Convert to Function0 ASAP
 */