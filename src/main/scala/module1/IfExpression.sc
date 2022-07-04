/**
 * In Scala, if..else expressions can return values (unlike many more
   imperative languages):
 * You can ignore the returned value, then it looks just like other languages:
 */
val a = 10
val b = 20
val m = if(a > b) a else b

var m = 0
if (a > b) {
  m = a
} else {
  m = b
}
println(m)

