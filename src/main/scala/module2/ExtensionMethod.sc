/**
 * -> can be called on an instance of any type with one parameter of any other type
 * The result is a tuple2[FirstType, SecondType] with the values of both instances
 * It's mainly syntactic sugar for creating maps, but it's not a keyword.
 * Here's how it works:
 */

1 -> "one" // (Int, String)val map = Map(1 -> "One")
val map2 = Map(1.->("One"))
val map3 = Map(ArrowAssoc(1).->("one"))

// is re-written to
1.->("one")
// is expanded to
ArrowAssoc(1).->("one")

/**
 * No such -> method exists on Int, but an implicit called ArrowAssoc provides it just in time
 */

val map = Map(1 -> "One", 2 -> "Two")
val map2 = Map(1.->("One"))
val map3 = Map(ArrowAssoc(1).->("one"))

//All that effort for -> is to make maps easy and pretty to initialize
val mapToRich = Map(
  1 -> "steal underpants",
  2 -> "???",
  3 -> "profit"
)

//They are also easy (and pretty) to iterate over with a for expression
for ((step, instruction) <- mapToRich) {
  println(s"Step $step - $instruction")
}

/**
 * The (step, instruction) unpacks the tuple2 from the sequence in the map
 * However, remember that the order may vary in some map implementations
 */