/**
 * case classes and tuples are Product types.
 * Their equality is determined by their public state and
    (for case classes) their type.
 */

(1, '2', "three") == (1, '2', "three")
(1, 'a', "three") == (1, '2', "three")

case class Triplet1(i: Int, ch: Char, str: String)
Triplet1(1, '2', "three") == Triplet1(1, '2', "three")
Triplet1(1, '2', "three") == Triplet1(2, '2', "three")
Triplet1(1, '2', "three") == (1, '2', "three")

case class Triplet2(i: Int, ch: Char, str: String)
Triplet2(1, '2', "three") == Triplet2(1, '2', "three") // true
Triplet2(1, '2', "three") == Triplet2(2, '2', "three") // false
Triplet1(1, '2', "three") == Triplet2(1, '2', "three") // false
Triplet2(1, '2', "three") == (1, '2', "three")

// ProductTypeFeatures
val triplet = Triplet2(1, '2', "three")
triplet.productArity
triplet.productIterator.toList
triplet.productElement(2)
triplet.productPrefix

val tuple = (1, '2', "three")
tuple.productArity
tuple.productIterator.toList
tuple.productElement(2)
tuple.productPrefix