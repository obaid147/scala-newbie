/**
 * The sealed is a Scala keyword used to control the places where given trait or class can be extended.
 * The subclasses and the implementations can be defined only in the same source file as the sealed trait or class.
 */

sealed class AccountType
case class Checking() extends AccountType
//case object Checking extends AccountType
case class Savings() extends AccountType
//case object Savings extends AccountType
def checking(at: AccountType): Boolean = at match {
  case Checking() => true
  case _ => false
}
checking(Checking())
checking(Savings())

/**
 * Sometimes you want to control what different types may be in a hierarchy
 * The sealed keyword gives you this, and pattern matches can then give
    warnings about incomplete matches
* */

// Warning:(6, 43) match may not be exhaustive.
// It would fail on the following inputs: AccountType(), Savings
// def checking(at: AccountType): Boolean = at match {
/**
sealed means that the only sub-types of the sealed class or trait must be
defined in the same source file*/
