val fn1: (Int, Int) => Int = (a, b) => a + b
fn1(10,20)

val fn2 = new Function2[Int, Int, Int] {
  override def apply(a: Int, b: Int): Int = a + b
}
fn2.apply(1, 2)
val fnCurried = fn1.curried
fnCurried(9)(3)
fnCurried(1)(_)
//fnCurried(_)(2) Error missing param
//fnCurried(_)(_) Error missing param

val fnTupled = fn1.tupled
fnTupled(2, 3)

val tup = (2, 3)
fnTupled(tup)
//fn1(tup) not enough arguments