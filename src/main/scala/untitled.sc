object FactSeqNested{

  def factSeq(n: Int): List[Long] = {
    //    factSeqInner(n, List(1L), 2)
    //    We cannot keep it here, Because In scala last statement is the return statement

    import scala.annotation.tailrec
    @tailrec
    def factSeqInner(acc: List[Long], ct: Int): List[Long] = {
      if(ct > n) acc
      else factSeqInner(ct * acc.head::acc, ct + 1)
    }
    factSeqInner(List(1L), 2)
  }
}
FactSeqNested.factSeq(4)

import scala.language.implicitConversions
implicit def doubleToInt(d: Double): Int = d.toInt
val x: Int = 24.7

def fn2: (Int, Int) => Int = (a, b) => a + b
fn2(2, 3)

implicit val d2I: Double => Int = i => i.toInt
d2I(x)
doubleToInt(2.2)













