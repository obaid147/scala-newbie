import scala.annotation.tailrec

object FactSeqScoped{

  def factSeq(n: Int): List[Long] = {
    @tailrec
     def factSeqInner(acc: List[Long], ct: Int): List[Long] = {
      if (ct > n) acc
      else
        factSeqInner(ct * acc.head :: acc, ct + 1)
    }
    factSeqInner(List(1L), 2)
  }
}
FactSeqScoped.factSeq(4)