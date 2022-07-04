/**
 * Ignoring the return value means you will need side effects to do anything
   useful, e.g. in this example we mutate a variable as our side effect
 * Purely functional code avoids side-effects (and does not need vars)
 * Hence Scala places a greater emphasis on expressions (that return values)
   rather than statements (that do not)
 * In a Scala expression consisting of more than one nested expression, the
   final inner expression becomes the value of the overall expression, e.g.
 */
var a = 10
var b = 12
val maxSquaredDouble = if (a > b){
   val aSquared = a * a
   aSquared * 2
} else{
   val bSquared = b * b
   bSquared * 2
}

/**
 * Scala does have a return keyword,
   but there is rarely any need to use it.
 */