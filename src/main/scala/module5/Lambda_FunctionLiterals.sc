def multiplyMethod(a: Int, b: Int): Int = a * b
def multiplyFunction: (Int, Int) => Int = (a, b) => a * b
multiplyMethod(3, 2)
multiplyFunction(3, 2)

val nums = (1 to 5).toList
nums.map(x => x * x)
nums.map(x => x * 3)
nums.map(x => x % 2 == 0)
/**
 * Scala calls the apply method on any object
 * or instance followed immediately by parens
 * Therefore if we make a class or instance that overrides
 * apply, that will be invoked by a function call
 * When you create a new instance of a function,
 * that is called a function value
 */
// takes 2 Ints and returns Int without assignment to fn1
val fn1: (Int, Int) => Int = (a, b) => a + b
fn1(2, 3)
fn1.apply(2, 3)
// takes 2 Ints and returns Int with assignment to fn2
val fn2 = new Function2[Int, Int, Int] {
  override def apply(a: Int, b: Int): Int = a + b
}
// below two, apply method is invoked by function call
fn2(2, 3)
fn2.apply(2, 3)
val x = fn2 // x is a new instance of function and is called
// function value
x.apply(1, 2)


val fn1Curried = fn1.curried
fn1Curried(1)(2)

val fn1Tupled = fn1.tupled
fn1Tupled(2, 2)

val fn1curried = fn1.curried
fn1curried(2)(3) // 5
val fn1tupled = fn1.tupled
val tup = (2, 3)
// fn1(tup) // won't compile
fn1tupled(tup) // 5