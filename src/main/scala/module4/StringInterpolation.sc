val x = 10
val y = 2.12
val name = "Fred"
s"$name $x $y" // Fred 10 2.12
s"$name is ${x * y}" // Fred is 21.200000000000003

f"$name is ${x * y}%08.4f" // Fred is 021.2000

/**
 * limit digits after . point and
 * make it 7 digits long including decimal point = 8
 * and also keep 4 digits after decimal point
 * We use an 'f' instead of 's' before the start of the string
 */

//s"$names" // won't compile!
s"${name}s" // Freds
//concatenation

// escape characters / escape sequence
"\t\n" // tab and newLine
raw"\t\n" // here escape sequence does not work ----- o/p -> \t\n
"""\t\n""" // here escape sequence does not work ----- o/p -> \t\n

"""I took a "LANGO"
  |and prem followed!""".stripMargin
// when we give new line after "LANGO", .stripMargin is automatically added by intellij/intellisence
// This also gives a new line in our output


val s = """I took a "LANGO"
          |and prem followed!""".stripMargin
println(s)

s"""$name took a "LANGO"
  |and prem followed!""".stripMargin


/**
 * f interpolation follows the printf notation
 * raw does not escape literals in the string
 */

val x = if(1 > 2) println(2) else println(3)