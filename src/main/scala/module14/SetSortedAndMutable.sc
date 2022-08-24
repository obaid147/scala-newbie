//Sets maintain unique identity, but not order
val vowels = Set('a', 'e', 'i', 'o', 'u')
vowels.contains('a') // true
vowels.contains('t') // false
vowels('a') // true
vowels('t') // false
vowels + 'y' // Set(e, y, u, a, i, o)
vowels + 'e' // Set(e, u, a, i, o)
val commonLetters = Set('e','t','a','o','i','n','s','r','h')
commonLetters intersect vowels // Set(e, a, i, o)
commonLetters diff vowels // Set(s, n, t, h, r)
vowels diff commonLetters // Set(u)
commonLetters union vowels // Set(e, s, n, t, u, a, i, h, r, o)
"hello to me".count(vowels) // 4

/*Set.apply and Set.contains are equivalent
Set[T] extends T => Boolean and can be used as a
predicate
*/

// ----- Sorted and MutableSet
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
