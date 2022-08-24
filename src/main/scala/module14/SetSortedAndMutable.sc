/**
 * Sets don't maintain insertion order,
 * but can be sorted, e.g. TreeSet */
import scala.collection.immutable
immutable.TreeSet('u', 'o', 'i', 'e', 'a')

import scala.collection.mutable
val set = mutable.Set('u', 'o', 'i', 'e', 'a')

//Mutable sets can be added to
// and removed from (of course)
set += 'y' // added y to set
set('y') // set contains y. true

set -= 'y'// removed y from set
set('y') // set contains y. false

set('y') = true // statement
set('y') // above statement makes it true

set('y') = false // statement
set('y') // above statement makes it false