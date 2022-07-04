/**
 * map() is a higher order function.
 * Every collection object has the map() method.
 * map() takes some function as a parameter.
 * map() applies the function to every element of the source collection.
 * map() returns a new collection of the same type as the source collection.
 */

def square(a:Int):Int = a*a

val myCollection = List(1, 3, 2, 5, 4, 7, 6)

// transformed collection
val new_collection = myCollection.map(square)
// takes function as param
println(new_collection)

// using lambda / Anonymous function

val myCollection2 = List(2, 3, 4)
val newCollection = myCollection2.map(x => x * x)
println(newCollection
)