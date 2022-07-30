import scala.annotation.tailrec

object FactSeq{

  def factSeq(n: Int): List[Long] = {
    factSeqTail(n, List(1L), 2)
  }

  @tailrec
  private def factSeqTail(n: Int, acc: List[Long], ct: Int): List[Long] = {
    if (ct > n)
      acc
    else
      factSeqTail(n, ct * acc.head :: acc, ct + 1) // prepend
  }

}

FactSeq.factSeq(4)