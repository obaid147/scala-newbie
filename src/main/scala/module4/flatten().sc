val myCollection = Seq("Obaid", "Fayaz", "Wani")

val flattenCollection = myCollection.map(_.toLowerCase)

println(flattenCollection)

//val res2 = myCollection.flatten
val res2 = flattenCollection.flatten

/**
 * flatten() method is a member GenericTraversableTemplate
 trait, it returns a single collection of elements by merging child collections.
 */