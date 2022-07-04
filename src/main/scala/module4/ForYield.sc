//Range ----> Range is like an ArithmeticExpression, As soon as we start mapping functions over,
// it gives up trying to keep this thing in an arithmetic expression
1 to 10
/**
 * When we use Yield, Instead of returning unit, It returns whatever the type we start first in for loop
    for( i <- 1 to 10) yield i*i first type here is collection i.
 * It will return a collection with the results of this function i*i run over the top of it.
 *
 */
//1
val squares = for(i <- 1 to 10) yield i * i
/**
 * Scala uses re-writing rules for this 'for', This turns it into same thing below as range.map(i => i * i) mapping
 * this function (i => i * i) over the top.
 * This function says, TAKE THIS value i and call i * i on it to get the square. but now this is a map, We get back a collection
 * For yield blocks, all generators are flatMap except the last which is map
 */
// 2
for (i <- 1 to 3; j <- 1 to 3) yield i * j
(1 to 3).flatten(i => (1 to 3).map(j => i * j))
(1 to 3).flatMap(i => (1 to 3).map(j => i * j))


//3
(1 to 10).map((i: Int) => i * i)

//3
for {
    i <- 1 to 3
    j <- 1 to 3
    k <- 1 to 3
} yield i * j * k
// scala does not do the foreach but it does the flatmap
(1 to 3).flatMap(i => (1 to 3).flatMap(j => (1 to 3).map(k => i * j * k)))

// For yield blocks, all generators are flatMap except the last which is map