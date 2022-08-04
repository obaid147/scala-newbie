// Extractor objects and use cases for them in Scala pattern matching.
/** 1. OverView
 * In Scala, every object that has an unapply() method is called an extractor object.
 * The unapply() method is the basis of pattern matching in Scala because this method
      helps us to extract data values compacted in objects
 */

/** 2. apply() and Factory Methods
 * Since the unapply() method is the opposite of the apply() method,
 * before introducing extractor objects, we need to know about the apply() method.
 */

class User(val name: String, val age: Int)
val user1 = new User("obaid", 28) // new instance

// We can use the apply() method as a factory method in the User’s companion object:

object User2{
      def apply(name: String, age:Int) = new User(name, age)
}
// Now, by calling the apply() method, we can instantiate our User class
val user2 = User2.apply("obaid2", 22)

// syntactic sugar version of apply()
val user3 = User2("obaid3", 12)

// we can write multiple apply() methods for our User class:
object User3{
      def apply(name: String, age: Int) = new User(name, age)
      def apply(name: String) = new User(name, 0)
      def apply(age: Int) = new User("Acer", age)
}
val u31 = User3("Dell", 55)
val u32 = User3("Hp")
val u33 = User3(26)
u31.name
u32.age
u33.name

/** 3. unapply() and Extractor Objects
 * The unapply() method is just the opposite of the apply() method.
 * This method extracts all object values and lists them as a result.
 * The best practice is to put the unapply() method in the companion object of our class:
 */

object User4{
      def unapply(u: User): Option[(String, Int)] = Option(u.name, u.age)
}
val u4 = new User("Name is User4", 22)
// Now we can call unapply() explicitly:
User4.unapply(u4)

/**
 * This is how pattern matching in Scala extracts object values.
 * Without the unapply() method, we can’t do pattern matching:
 */

u4 match {
      case User4(_, age) if age < 18 =>
            println("You are not allowed to get a driver license.")
      case User4(_, age) if age >= 18 =>
            println("You are allowed to get a driver's license.")
}

/** 4. unapplySeq() and Deconstructing Sequences
 * The unapply() method is useful when we’re going to extract
 * various single-value items, such as the name and age
 * from a User. On the other hand, if we want to deconstruct
 * an instance to a collection of values,
 * we should use the unapplySeq() method. */

/***For example, let’s suppose we’re going to deconstruct an
 * HttpRequest instance to its Headers: */

case class Header(key: String, value: String)
class HttpRequest(val method: String,
                  val uri: String,
                  val headers: List[Header])

// If we declare a unapplySeq() method in the companion object:
object HttpRequest{
      def unapplySeq(request: HttpRequest) =
            Option(request.headers)
}

val headers: List[Header] =
            Header("Content-Type", "application/json") ::
            Header("Authorization", "Token") ::
            Header("Content-Language", "fa_IR") :: Nil

val request: HttpRequest = new HttpRequest(
      "GET", "localhost", headers)

request match {
      case HttpRequest(h1) => s"The only header is $h1"
      case HttpRequest(h1, h2) => s"Two header are $h1 and $h2"
      case HttpRequest(all @_*) => s"More than 3 headers $all"
}

/**
 * If we replace the unapplySeq() method with unapply(),
 * the same pattern will fail with the message:
 * too many patterns for object HttpRequest offering List[Header]
 * But if we have only 1 case in match, it will return h1
 */

// IMPORTANT
/**
 * when using unapply(), the whole List[Header] will be
 * considered as a single value, whereas unapplySeq() allows
 * us to pattern match against each member of the sequence.
 */