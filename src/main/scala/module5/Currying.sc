import scala.annotation.tailrec

def method(x: Int): Int = x + 1
method(1)

val functionLiteral: Int => Int = (x: Int) => x + 1
functionLiteral(2)

val functionLiteral2: Int => Int = functionLiteral
functionLiteral2(3)

def method2(): Int => Int = {
  functionLiteral
}
//method2()(4)
val r1: Int => Int = method2()
r1(4)

def method3(): Int = functionLiteral(5)
val r2: Int = method3()

def method4(x: Int): Int => Int = {
  val g: Int => Int = (y: Int) => y + x
  g
}
val r3: Int => Int = method4(6)
val rx = r3(1)

def method5(x: Int) = {
  (y: Int) => x + y
}
val ry = method5(7)
ry(1)
// ***
def methodLearn(f: Int => Int): Int => Int = {
  val g = (x: Int) => {
    val res = f(x)
    res + x
  }
  g
}
val ffl = (x: Int) => x * x
val xy: Int => Int = methodLearn(ffl)
xy(1)
//
///////////////////////////////
def method6(x: Int, y: Int): Int = {
  x + y
}
method6(1, 2)

def methodC1(x: Int) = {
  (y: Int) => x + y
}
val r1: Int => Int = methodC1(1)
r1(2)
methodC1(1)(2)// OR for r1(2)
def methodC2(x:Int)(y:Int): Int = x + y // OR for methodC1
methodC2(1)(2)

def methodOf4(
  a: Int, b: Int, c: Int, d: Int): Int = a + b + c + d
methodOf4(1, 2, 3, 4)

def methodOf4Curry(
  a: Int, b: Int, c: Int)(d: Int): Int = a + b + c + d
val c1 = methodOf4Curry(1, 2, 3)(4)

def methodOmit(
  a: Int, b: Int, c: Int): Int => Int = {
  (d: Int) => a + b + c + d
}
val g1 = methodOmit(1, 2, 3)
g1(4)
methodOmit(1, 2, 3)(4)

def methodOmit2(a: Int, b: Int): Int => Int => Int ={
  (c: Int) => {
    (d: Int) => a + b + c + d
  }
}
val m1 = methodOmit2(1, 2)
val m2 = m1(3)
m2(4)
methodOmit2(1, 2)(3)(4)


def methodOmit3(a: Int): Int => Int => Int => Int = {
  (b: Int) => {
    (c: Int) => {
      (d: Int) => {
        a + b + c + d
      }
    }
  }
}

val n1 = methodOmit3(1)
val n2 = n1(2)
val n3 = n2(3)
n3(4)
methodOmit3(1)(2)(3)(4)
// ----------------------------------------------------


def sumF1(f: Int => Int): (Int, Int) => Int = {
  def Inner(a: Int, b: Int): Int = {
    if(a > b) 0 else f(a) + Inner(a + 1, b)
  }
  Inner
}

def sumF2(f: Int => Int)(a: Int, b: Int): Int = {
  if(a > b) 0 else f(a) + sumF2(f)(a + 1, b)
}

def cube(x: Int): Int = x * x * x

val x1 = sumF1(x => x)
x1(1, 2)

val x2 = sumF2(x => x)(1, 2)

val x3 = sumF1(cube)
x3(1, 2)

val x4 = sumF2(cube)(1, 2)
