val numbers = List.range(0, 10)

numbers.grouped(3).toList
numbers.grouped(3).take(3).toList
// .take helps to set inner list range/count

numbers.sliding(3).toList
numbers.sliding(3).take(5).toList

//num.combinations(3).toList // all combinations
numbers.combinations(3).take(5).toList

//num.permutations.toList // all permutations
numbers.permutations.take(5).toList

val numPlusOne = numbers.map(x => x + 1)
numbers.corresponds(numPlusOne)((a, b)=> a + 1 == b)


