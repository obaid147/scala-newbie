val milList: List[Long] = (1L to 1000000L).toList
//sum of all numbers divisible by 3 and 5

val xs: List[Long] = milList.filter(x => x % 3 == 0 && x % 5 == 0)
xs.reduce((a,b) => a + b)
xs.sum

val forEvenList = (1 to 10).toList
// sum of even numbers in a list
println("Even Double the number")
val doubleTheEvenNumber = forEvenList.filter(x => x% 2 == 0)
doubleTheEvenNumber.map(x => x + x)


val listOfNumbers = (1 to 10).toList

listOfNumbers.map(x => x * x)
listOfNumbers.filter(x => x % 2 == 0)
listOfNumbers.filter(x => x % 2 != 0)

listOfNumbers.reduce((a , b) => a + b)
listOfNumbers.sum

val n = listOfNumbers.map(x => x * x)
n.filter(x => x % 2 == 0)