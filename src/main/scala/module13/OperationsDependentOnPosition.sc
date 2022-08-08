val nums1 = (1 to 5).toList
nums1.drop(3)
// drop:- drops first n elements and return remaining elements
// If .drop does to find the total elements passed as an int,
//          It Returns an empty list

nums1.take(3) // returns first n elements,
// unlike drop it does not return an empty,
// unless the we do .take(n) operation on an empty list

val nums2 = (6 to 10).toList

val allNums = nums1 :: nums2 // right associative returns list[Any]
val allNums = nums1 ::: nums2 // concatenation

allNums.drop(8)
allNums.drop(17).headOption
allNums.updated(4, 100)
/** * ::: (concat)
 * duplicate the first List but re-uses the second.
 * Now, Drop will not return an empty List.
 * updated must make a new List up to the specified position,
    but re-uses the rest.

 */

