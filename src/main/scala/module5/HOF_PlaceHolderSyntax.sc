val nums = (1 to 5).toList
nums.map(x => x * x) // List[Int]

nums.filter(x => x % 2 == 0) // Takes bool as condition => List[Int]
nums.filter(x => x < 4) // Takes bool as condition => List[Int]

nums.span(x => x % 4 != 0)
// Span will first create a collection util the predicate is false,
// Once predicate is false, 2nd collection is created with remaining items

nums.partition(x => x % 4 != 0)
// This creates first collection for predicate  true.
// 2nd collection for predicate  false.
/**
 * Placeholder can only be used where each parameter is used exactly ONCE in order
 * E.g. _ * _ cannot be used instead of x => x * x as x is used twice
 * ???????????????????The _s cannot be inside parens either (that means something different),
 * so_ - _ // can be substituted for (a, b) => a - b
 * but (_ - _).abs // cannot be substituted for (a, b) => (a - b).abs
 */

println("-"*20 + "PlaceHolderSyntax") //PlaceHolder Notation

nums.filter(_ < 4)// nums.filter(x => x < 4) ---Naming x and using x only once
// replace x => x with _
nums.span(_ % 4 != 0)// nums.span(x => x % 4 != 0) ---Naming x and using it once
// replacing x => x with _ again

nums.partition(_ % 4 != 0)

nums.map(x => x * x) // we cannot replace it with this _ because x is being used twice

def compareNeighbors(xs: List[Int],
  compare: (Int, Int) => Int): List[Int] = {
  for (pair <- xs.sliding(2)) yield {
    compare(pair.head, pair(1))
  }
}.toList

compareNeighbors(nums, _ + _) // (a, b) => a + b
//compareNeighbors(nums, (_ - _).abs) will not compile