/*Retrying example*/
case class RetryParams(times: Int)

import scala.util.control.NonFatal
/**Returns true if the Throwable is non-fatal, or false if it is to be considered fatal.*/

def retryCall[A](fn: => A, currentTry: Int)(retryParams: RetryParams): A = {
  try {
    fn
  }catch {
    case NonFatal(_) if currentTry < retryParams.times =>
      retryCall(fn, currentTry+1)(retryParams)
  }
}

def retry[A](fn: => A)(retryParams: RetryParams): A =
  retryCall(fn, 0)(retryParams)

var x = 0
def checkIt(): Int = {
  x = x+1
  require(x > 4, "x should be less than 4")
  x
}

//retry(checkIt())(RetryParams(3)) // good thing to have param as only fn


/* Implicit*/
def retry1[A](fn: => A)(implicit retryParams: RetryParams): A = retryCall(fn, 0)(retryParams)

implicit val defaultRetry: RetryParams = RetryParams(3) // scala uses this automatically
retry1{
  checkIt() //we use curly braces (valid for single parameter lists) to make things look nice
}

/*Explicit Overrides*/

/**
 * Implicits are looked up by the Scala compiler when required.
 * If code will compile without an implicit, Scala will not look one up or apply it.
 * Therefore you can always override implicits with an explicit parameter.
*/
retry1(checkIt())(RetryParams(1))
/**
 * Implicit parameter lists can have more than one parameter.
 * Only the final parameter list can be implicit.
 * If any implicits are explicitly provided, all of them must be provided.
 * implicit keyword is only placed at the head of the parameter list, not on each parameter.
*/
def method(item1: String, item2: Int)(implicit p1: String, p2: Int, p3: Boolean)

/**
 * The type is what matters to the Scala compiler, not the name.
 * Although the name may be used to override or hide definitions.
 * There can be no ambiguity, It will not pick from two implicits with the same type.
*/