/**
 * The progression of tests only continues until the first match of everything to
   the left of the =>
 */
val x = 1

/*val matcher1: Unit = */x match {
  case 1 => println("One")
  case 2 => println("Two")
  case _ => println("One")
} // returns unit

/*val matcher2: String = */x match {
  case 1 => "One"
  case 2 => "Two"
  case _ => "One"
}

// We are using guard here from FourG's Of For
val y = 'a'
/*val guardMatcher =*/
  y match{
    case 0 => "It's a Zero"
    case v if y > 0 => s"It's a Positive number $v" // guard is before => 'rocket'
    // compiler takes y and puts it in v, which becomes a val, that has this value in it
    case v => s"It's a Negative number ${v.abs}" // here we have no guard, this would match anything else here
    case _ => "None of the numbers" // matches the above line as there is no guard
  }

/**
 * Match and more match
 * Can match Strings, Lists, more...
 * More on match later in the course
 */

def matchIt(num: Any): String = num match {
  case "Hello" => "Well Hello back"
  case 1 :: rest => s"A list beginning with 1, rest is $rest"
  case Nil => "An Empty list"
  case 5 => "The number is 5"
  case _ : List[_] => "Some kind of list, not empty and not starting with 1"
}

matchIt(5)
matchIt(List(1, 2, 3))
matchIt(List(1))
matchIt(List(10, 20))
matchIt(Nil)
//matchIt(2.0) MatchError
// We can use case anythingElse => s"This is $anythingElse"
