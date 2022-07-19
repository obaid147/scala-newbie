package module5

object MapReduce_Currying extends App{

  def mapReduce(f: Int => Int,
    combine: (Int, Int) => Int,
    zero: Int)(a: Int, b: Int): Int =
    if (a > b) zero
    else {
      combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
    }

  def prodF4(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y)=> x * y, 1)(a, b)
  println(prodF4(x => x * x)(2, 3))


  //  def f(x: Int => Int) = x
  //  println(f(x => x * x)(10))
  def m1(x: Int => Int) = x(4)
  println(m1(z => z * z))

  val f1: Int => Int = x => x * x
  println(f1(4))

  val f2 = new Function[Int, Int] {
    //  val f2: Int => Int = x => x + 2
    override def apply(a: Int): Int = a + 2
  }
  println(f2(19))

  //  val add3Num = (a: Int, b: Int, c: Int) => a + b + c
  //  def add3Num(a: Int, b: Int, c: Int) = a + b + c
  val add3Num: (Int, Int, Int) => Int =  (a, b, c) => a + b + c
  println(add3Num(1, 2, 3))
  val p = add3Num(1, _, 2)
  println(p(57))

  val add5and4 = add3Num(5, _:Int, 4)
  println(add5and4(1))
}



