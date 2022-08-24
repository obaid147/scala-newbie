/** Iterators are lazy collections
 * They potentially return a new value on each .next call
 * When something returns a different value each time,
    that means it's not functional.
 */

val nums: List[Int] = List.range(1, 21)//exclusive
val numsIterator: Iterator[Int] = nums.iterator
// here We don't get Eager collection
//if(numsIterator.length > 0) numsIterator.next()
// .length exhausts the iterator use .hasNext
// or convert to other collection
if(numsIterator.hasNext) numsIterator.next()
if(numsIterator.hasNext) numsIterator.next()


