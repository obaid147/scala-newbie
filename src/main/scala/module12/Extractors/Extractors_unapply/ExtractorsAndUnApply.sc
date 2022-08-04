case class Person(first: String, last: String, age: Int)

val p1 = Person("Obaid", "Fayaz", 28)

Person.unapply(p1) // Option[Person]
/**
 * unapply method extracts an object and
      returns back the attributes.
 * This method is also used in Pattern matching and
      Partial functions.
 * Extractors also explains apply method, which takes
    the arguments and constructs an object so,
    it’s helpful in constructing values.
 * The unapply method reverses the construction
    procedure of the apply method.
*/

// The return type of the unapply method can be selected like:
/**
 * If it is a checking procedure then return a Boolean Type.
 * If the procedure is returning only one sub-value of type T,
    then return an Option[T].
 * If the procedure is returning various sub-values of type T1,
    T2, …, Tn then return an optional tuple i.e,
    Option[(T1, T2, …, Tn)].
 * If the procedure returns an unpredictable number of values,
    then the extractors can be defined with an unapplySeq that
    returns an Option[Seq[T].]
 */

  object A{
  def apply(firstName: String, lastName: String): String={
    firstName+"Fayaz"+lastName
  }

  def unapply(x: String) = {
    val y = x.split("Fayaz")
    if(y.length == 2) Option(y(0), y(1))
    else None
  }
}
val n1: String = A.apply("Obaid", "Wani") // A("Obaid", "Wani")
val n2: Option[(String, String)] = A.unapply("ObaidFayazWani")
//

object B{
  def apply(d: Double): Double = d * 50

  def unapply(i: Int): Option[Int] =
    if(i % 2 == 0) Option(i * 5)
    else None
}
B(10) // B.apply(10)
B.unapply(10)
B(20)

object C{
  def main(args: Array[String]): Unit ={
    val x = C(10)
    println(x)

    val y = C.unapply(10)
    println(y)

    val matcher = x match {
      case C(n) => s"Value is $n"
      case _ => "Cannot Evaluate"
    }
    println(matcher)

  }
  def apply(d: Double): Double = d / 5
  def unapply(z: Double): Option[Double] =
    if (z % 5 == 0) Option(z/5)
    else None
}
C(10)
C.unapply(10)

// check ExtractorPatternMatch.scala and ExtractorBoolean.scala for
// pattern match and boolean
