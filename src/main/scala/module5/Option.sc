val aList = List(1, 2, 3)
val listTransform = aList.map(x => x + 1)
val listTransform_2 = aList.flatMap(i => aList.map(j => (j, i+j)))
val listTransform_2_2 = aList.flatMap(x => List(x, x+1))
val listFilter = aList.filter(x => x % 2 == 0)
val combinedList = for{ // chain of map and flatMap
  num <- List(1, 2, 3)
  char <- List('a','b')
} yield s"$num-$char" // same as below
// list(1,2,3).flatMap(num => List('a', 'b').map(char => s"$num-$char"))

// USE Option/Some/None Whenever a function is expected to return a null value
/**
 * Option can be thought of as many lists with at most one element.
 * // Option is a "List" with at most one element.
 * // option contains a single value or no value
 * */
val anOption: Option[Int] = Option(4) // value to this will be Some(4)
val anOption_2: Option[Int] = Some(4) // This is the same
/**
 * Some is a simple class which contains a single value.
 * Some is a subtype of tha main Option type.
* */

val anEmptyOption: Option[Int] = Option.empty // None
val noneOption_2: Option[Int] = None

val aTransformOption: Option[Int] = anOption.map(x => x * 10)
val aOptionTransform_2: Option[Int] =
  anOption.flatMap(x => Option(x * 10))
val aOptionTransform_2_1: Option[Int] =
  anOption.flatMap(x => anOption.map(y => x + y))

val aOptionMap = anOption.map(x => Option(x * 10))

val anOption1: Option[Int] = anOption.filter(x => x > 20)

/**
 * for comprehension
 * when we can do map,flatMap, filter etc on anything
 * that means we can also use for comprehension there instead of map etc...
* */

val n = for{
  num1 <- Option(2)
  char1 <- Option('a')
} yield s"$num1-$char1"

// Option API
val checkEmpty: Boolean = anOption.isEmpty
val innerValue: Int = anOption.getOrElse(99)
val innerValue: Int = anEmptyOption.getOrElse(99)

val chainOption = anEmptyOption.orElse(anOption)

/**
 * Option describes the possible absence of a value
 */
def unSafeMethod(arg: Int): String = null // always returns null

// defensive code
val potentialValue = unSafeMethod(44) // null
val myRealResult = // "Error"
  if(potentialValue == null) "Error"
  else potentialValue.toUpperCase()

val callToExternalService = unSafeMethod(55)
// Now i want to combine potentialValues and call2ExtService by
// running some methods on them, i have to check against both nulls

val combinedResult =
  if (potentialValue == null) {
    if(callToExternalService == null)
      "Error1"
    else
      "Error2"
  } else {
    if(callToExternalService == null)
      "Error 3"
      else
      potentialValue.toUpperCase() + callToExternalService.toUpperCase()
  }

/**
 * Look how many line of code we wrote above,
 */

val betterCombinedResult: Option[String] = for{
  firstValue <- Option(unSafeMethod(44))
  // Regardless of whether unsafeMethod returns a valid string or null,
  // Option of that thing will return an option string with regardless of whether it contains a value or not
  secValue <- Option(unSafeMethod(55))
} yield firstValue.toUpperCase + secValue.toUpperCase
// Returns None instead of that null value
// As it is of type option, we can use as follows:-

betterCombinedResult.getOrElse("We Now Have a value")

// -------------------  https://alvinalexander.com/scala/using-scala-option-some-none-idiom-function-java-null/
def toInt(in: String): Option[Int] = {
  try {
    Some(Integer.parseInt(in.trim))
  } catch {
    case e: NumberFormatException => None
  }
}

toInt("123")
/**
 * It takes a String as a parameter.
 * If it can convert the String to an Int,
        * it does so, returning it as Some(Int).
 * If the String can't be converted to an Int,
        * it returns None.
 **/
//If you're a consumer of this toInt function,
// your code will look something like this:
toInt("123311") match {
  case Some(i) => println(i)
  case None => println("That didn't work.")
}

/**
 * (1) In the first case,
 * if you didn't look at the Javadoc for the Java toInt method,
 * you might not know that toInt could return a null,
 * and your code could potentially throw a NullPointerException.

 * (2) In the second case, if you did happen to read the Javadoc,
 * and did see that the code could return a null, you might handle it like this:
 *
 * Integer i = toInt(someString);
  if (i == null) {
      System.out.println("That didn't work.");
  } else {
      System.out.println(i);
  }
 *The java code isn't any worse than the Scala Option and match approach,
 *  but you did have to read the Javadoc to know this was needed.

 * (3) In the third case, the programmer of the toInt function could handle
        * the NumberFormatException differently,
        * and return some other value besides null, in this case,
        * perhaps zero or some other meaningless number.
 */

//  let's see where Scala shines.

/**
 * Let's assume you want to get the sum of a List
      * that contains a bunch of String values, and some of those strings
      * can be converted to Int values, and some can't
 */

val bag = List("1", "2", "foo", "3", "bar")
//val sumMap = bag.map(toInt)
val sumFlatMap = bag.flatMap(toInt).sum

/**
 * Because (a) we've written toInt to return either a Some[Int] or None value, and
 * (b) flatMap knows how to handle those values, writing this line of code is a piece of cake,
 * and again, it's easy to read and understand.
*/