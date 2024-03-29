/**
 * A function literal (or lambda) is just a function (like a method) that may not have a name.
 * From the point of view of the caller, the syntax is interchangeable, e.g.
 * */

def multiplyMethod(a: Int, b: Int): Int = a * b
val multiplyFunction: (Int, Int) => Int = (a, b) => a * b
multiplyMethod(2, 3)
// res0: Int = 6
multiplyFunction(2, 3)
// res1: Int = 6

// behind the scenes Function 2 is created
val fn1 = new Function2[Int, Int, Int] {
  override def apply(a: Int, b: Int): Int = a + b
}
// another way of writing
val fn2: Function2[Int, Int, Int] = (a: Int, b: Int) => a + b


val nums = (1 to 5).toList

// List[Int] = List(1, 4, 9, 16, 25)
def multiplyMethod(xs: List[Int]) = {
  xs.map(x => x * x)
}
multiplyMethod(nums)
nums.map(x => x * x)
//1
val multi: Int => Int = x => x * x
nums.map(multi)


// List[Int] = List(3, 6, 9, 12, 15)
def multiplyMethod2(xs: List[Int]) = {
  xs.map(x => x * 3)
}
multiplyMethod2(nums)
nums.map(x => x * 3)
//2
val multi1: Int => Int = x => x * 3
nums.map(multi1)

// List[Int] = List(false, true, false, true, false)
def boolMethod(xs: List[Int]) = {
  xs.map(x => x % 2 == 0)
}
boolMethod(nums)
nums.map(x => x % 2 == 0)
//3
val multi2: Int => Boolean = x => x % 2 == 0
nums.map(multi2)