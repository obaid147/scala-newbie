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