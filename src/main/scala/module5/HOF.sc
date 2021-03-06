import scala.annotation.tailrec

//def sum(f: Int => Int, a: Int, b: Int): Int ={
//    if(a > b) 0
//    else
//        f(a) + sum(f, a+1, b)
//}

def sumF(f: Int => Int): (Int, Int) => Int = {
        def sumInner(a: Int, b: Int): Int = {
                if(a > b) 0
                else f(a) + sumInner(a + 1, b)
        }
        sumInner
}
// another syntactic sugar
def sumF1(f: Int => Int)(a: Int, b: Int): Int =
        if(a > b) 0 else f(a) + sumF1(f)(a + 1, b)


//def id(x: Int): Int = x
def cube(x: Int): Int = x * x * x
@tailrec
def fact(x: Int): Int = if(x == 0) 1 else fact(x - 1)

//def sumInts(a: Int, b: Int): Int = sum(id, a, b)
//def sumInts(a: Int, b: Int): Int = sum(x => x, a, b)
def sumInts = sumF(x => x)
//def sumCubes(a: Int, b: Int): Int = sum(cube, a, b)
//def sumCubes(a: Int, b: Int): Int = sum(x => x * x * x, a, b)
def sumCubes = sumF(x => x * x * x)
//def sumFactorial(a: Int, b: Int): Int = sum(fact, a, b)
def sumFactorial = sumF(fact)

val xx1 = sumCubes
xx1(2, 3)
//sumInts(1, 2)
//sumCubes(1, 2)
//sumFactorial(1, 2)
sumCubes(1, 2) + sumFactorial(2, 3)
sumF (cube) (1, 2)
sumF(cube)(1, 2) == sumCubes(1, 2)
sumF(cube)(1, 2) == sumCubes(1, 2)
sumF(cube)(1, 2)== sumF1(cube)(1, 2)

/**
 * val str = "HeLlO WoRlD
val lowerCasedString = toLowerCase(string)
println(lowerCasedString)
val upperCasedString = toUpperCaseFunction(lowerCasedString)
println(upperCasedString)

def hof() = {
//all above operations in this function, use HOF and function literals
}
 */
val str: String = "This is a StRiNg"
//def lowerCaseFun(): String => String = {
//        (s: String) => s.toLowerCase()
//}
val lowerCaseFun: String => String =
(s: String) => s.toLowerCase()

val lowerCaseString: String => String = lowerCaseFun
lowerCaseString(str)


val upperCaseFun: String => String =
        (s: String) => s.toUpperCase()

val uppercaseString: String => String = upperCaseFun
uppercaseString(str)


def sumRec(f: Int => Int, a: Int, b: Int) = {
        @tailrec
        def loop(a: Int, acc: Int): Int = {
                if (a > b) acc
                else loop(a + 1, f(a) + acc)
        }
        loop(a, 0)
}
val n: Int = sumRec(x => x * x, 3, 5)

def sum(f: Int => Int)(a:Int, b: Int):Int = {
        if(a > b) 0 else {
                f(a) + sum(f)(a + 1, b)
        }
}

def sumInt: (Int, Int) => Int = sum(x => x)
def sumCube: (Int, Int) => Int = sum( x => x * x * x)

sumInt(1,3)

def mapReduce(default: Int, f: Int => Int, combine: (Int,  Int) => Int)(a:Int, b:Int): Int = {
        if(a > b) default else {
                combine(a, mapReduce(default, f, combine)(a + 1, b))
        }
}

/**
 *  c => x, y => x + y
   mapReduce(1,5)
   combine(1, mapReduce(2, 5)
   combine(2, mapREduce(3, 5))
   combine(3, mR(4,5))
   combiine(4, Mr(5. 5))
   comvine(5, 1)
 */