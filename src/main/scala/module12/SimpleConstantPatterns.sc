// In its simplest usage, Scala's match is like Java's switch:

def matchIt(x: Any): Unit =
  x match {
    case 10       => println("The number 10")
    case true     => println("This is the truth")
    case 2.0      => println("Double precision 2.0")
    case "hello"  => println("Well, hi there")
    case ()       => println("Unit")
    case _        => println("It's something else")
  }

matchIt(10)
matchIt(2.0)
matchIt("hello")
matchIt(())
matchIt(3) // Will match with _ which is default

// Match is an Expression
// if we has no default case _ which means a non-matching
//result will throw a MatchError exception
/*
The cases are checked in order, and the first successful match consumes
the match event
 */

def pair(s: String): String = s match {
  case "fish" => "chips"
  case "bacon" => "eggs"
  case "tea" => "scones"
  case "horse" => "carraige"
}
pair("fish") // chips
pair("tea") // scones
//pair("universe") // MatchError!
