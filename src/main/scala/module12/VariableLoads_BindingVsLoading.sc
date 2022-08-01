// loading a variable for default match

def opposite(s: String): String = s match {
  case "hot" => "cold"
  case "full" => "empty"
  case "cool" => "square"
  case "happy" => "sad"
  case anythingElse => s"not $anythingElse"
}
opposite("cool") // square
opposite("happy") // sad
opposite("sane") // not sane
// We should makes the pattern match complete for all inputs.
// Otherwise we get a MatchError.

/**
 * Binding vs Loading
 */

// A variable identifier in a pattern match is loaded with the value.
// But there is an alternative, useful for multiple-matches and in other situations, binding:

def opposite2(s: String): String = s match {
  case "hot" => "cold"
  case "full" => "empty"
  case "cool" => "square"
  case "happy" => "sad"
  case inWord @ ("sane" & "edible" | "secure") => s"in$inWord"
  case anythingElse => s"not $anythingElse"
}

opposite2("happy")
opposite2("sane")
opposite2("edible")
opposite2("fish")

// ("sane" | "edible" | "secure") matches any of those words, and the @ binds the result into inWord.
//More generally, @ binds the pattern match on the right of it to the variable on the left of it.