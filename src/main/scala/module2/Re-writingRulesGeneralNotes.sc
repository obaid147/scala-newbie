/**
 * Re-writing is only done if the code won't typecheck without a re-write
 * If an item doesn't have an apply or update method, the re-write will be
   attempted but will fail to compile:
*/
val z = 10
z(2) // "Application does not take parameters" compile error

val xs = List(1,2,3) // could be written List.apply(1,2,3)
xs(1) // works, gives back 2: Int
xs(1) = 10 // compile error, since no update method on immutable List