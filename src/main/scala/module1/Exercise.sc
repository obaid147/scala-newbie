/**
1. Create a Scala script file  in your working directory
   (make a directory if you need to)
2. Write two while loops from 1 to 5, one inside the other. Call one loop
   variable x and the other y
3. println a message in the inner loop that says s"$x times $y is ${x * y}
4. Remember to increment both x and y in their respective loops
5. Run
 */

var x = 1
val limit = 5

  while(x <= limit) {
    var y = 1
    while (y <= limit){
      println(s"$x times $y is ${x * y}")
      y += 1
    }

  x += 1
  }


/**
 * toString is a method that can be called on anything in Scala, for example:
 */

val n = 123
n.toString

/**Furthermore, Strings have a .contains method that checks to see if a Char
    is contained anywhere in the String: */
val s = "123"
s.contains('3')
s.contains('4')

/**
Alter your previous timestable.sc to only print out lines if the result of the
multiplication contains either a '4' or a '6' digit in the number produced.
|| is the logical or operator in Scala
*/