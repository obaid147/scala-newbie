/**
 * Higher Order Functions are simply functions
 * that takes other functions as an argument OR
 * returns a function.
 */

val words = List("four", "five", "char", "word")

words.reverse.map(x => x) // reverse the order of elements.

words.map(_.reverse) // reverse the elements four == ruof

words.reverse.map(_.reverse)
// reverse the elements and reverses the order of elements.

words.map(word => word.toList)
// returns everything like List(List(f, o, u, r),List(f, i, v, e))
// wrapped around a List coz we do list operation on list

words.flatMap(word => word.toList) // List(f,o,u,r,f,i,v,e,c..)
// create a single list of all elements as char

words.foreach(println)
words foreach println
// when we use empty () with println, it returns unit

words.foreach(word => println(word))
