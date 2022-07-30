// Calling var args with a Collection
//What if we want to greet an existing collection of names?
val names = ("obaid", "fayaz", "wani")

def greet(greeting: String, names: String*) = {
  for (name <- names) yield s"$greeting, $name"
}
greet("Hi", "Fred", "Julie", "Kin")
//greet("Hi", names) does not compile

/**
 * Note that if using expansion operator, the original collection type is retained (in this case, List)
   instead of converting to Array.
 * The expansion operator is occasionally useful,
   particularly for recursion over var-args methods.
 */