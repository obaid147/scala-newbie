/** Views is also a lazy collection
 * It stores up functions to run later on demand.
 * Lazy is Functional in nature.*/


val v = Vector.range(0, 20)
val vectorView = v.view
/** What view does
*  It bases a view on an existing collection.
 *  But it does not do anything to that collection, It
 *  just uses it as a base.
 */

def calcSquare(x: Int): Int = {
  println(s"Calculating Square of $x")
  x * x
}

val squareView = vectorView.map(calcSquare)
// view store calcSquare and does not call it
/**
 *  When we map things over a view, it keeps a record of
 *  the function we want to call and then later when
 *  we ask for things from the view,
 *  It applies the function Just in time
* */

squareView(2) // call calcSquare(2)
squareView(3)
squareView(4)
//squareView(20)
//IndexOutOfBoundsException vector(0 to 19) only
/**
 * It does not call a function unless asked.
 * */


val squares = squareView.force
// Eager evaluation of view
