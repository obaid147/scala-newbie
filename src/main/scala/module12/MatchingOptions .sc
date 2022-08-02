def matchOption(x: Option[Int]): String = x match {
  case Some(v) if v >= 10 => s"Number greater or equal to 10 ie: $v"
  case Some(v)            => s"Number less than 10 ie: $v"
  case None               => "No number given"
}
matchOption(Some(50)) // It's a number above 10
matchOption(Some(5)) // It's a number 10 or less
matchOption(None)

/**
 * There are only two states for Option, Some(x) and None
 * Can unpack variables from inside the option (and use them)
 * This is common usage, but there are often more idiomatic
 * ways of dealing with Option (e.g. map, getOrElse)
 */

val x1: String = matchOption(Some(40))
Some(9).get
Some().get
Some(9).getOrElse(())
