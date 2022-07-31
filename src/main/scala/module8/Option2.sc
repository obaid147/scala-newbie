// null is the absence of instance, compiler will not help us.

val s1: String = "Obaid"
val s2: String = null

s1.length
//s2.length // NullPointerException

// Making an Option type means the compiler has your back:

val os1: Option[String] = Option("Obaid")
val os2: Option[String] = None

os1.map(_.length)
os2.map(_.length) // change type from Option[Nothing] to [String]
//This takes a common runtime error, and moves it into a compile time concern