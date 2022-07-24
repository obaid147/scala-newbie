// previous example
val add3: (Int, Int, Int) => Int = (a, b, c) => a + b + c

val add3Curried = add3.curried

// we could write this function this way
val add3c: Int => Int => Int => Int = a => b => c => a + b + c

//The parens are not required, but can clarify what's happening

//call these curried functions:
add3(1, 4, 3)
add3Curried(4)(2)(3)
add3c(11)(2)(1)

add3c.apply(11).apply(2).apply(1)