/**
 * Along with the big 3 (List, Vector and Array) there are many other more
    specialized collections.

Many of these, e.g. Set, Queue, Stack have both mutable and immutable versions.
These are under scala.collection.immutable and scala.collection.mutable packages.

Best Practice, don't import directly from these, import the packages
instead.
 */

import scala.collection.mutable
import scala.collection.immutable

def popImmutableQueue(q: immutable.Queue[Int]): (Int, immutable.Queue[Int]) = q.dequeue
def popMutableQueue(q: mutable.Queue[Int]): Int = q.dequeue()

popImmutableQueue(immutable.Queue(1, 2, 3))
popMutableQueue(mutable.Queue(1, 2, 3))