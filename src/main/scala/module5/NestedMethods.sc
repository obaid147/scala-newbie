import scala.annotation.tailrec

object FactSeqNested{

  def factSeq(n: Int): List[Long] = {
//    factSeqInner(n, List(1L), 2)
//    We cannot keep it here, Because In scala last statement is the return statement

    @tailrec
    def factSeqInner(n: Int, acc: List[Long], ct: Int): List[Long] = {
      if(ct > n) acc
      else factSeqInner(n, ct * acc.head :: acc, ct + 1)
    }
    factSeqInner(n, List(1L), 2)
  }
}
FactSeqNested.factSeq(4)

/**
object Test{
  def mOuter(num: Int): (Int, String) = {

    def mInner(num: Int, str: String): (Int, String) = {
      (num, str)
    }

    mInner(num, "Obaid")
  }

}
Test.mOuter(10)*/
