package module5

object PrivateMethods extends App{

  import scala.annotation.tailrec

  object FactSeq{

    def factSeq(n: Int): List[Long] = {
      factSeqInner(n, List(1L), 2)
    }

    @tailrec
    private def factSeqInner(n: Int, acc: List[Long], ct: Int): List[Long] = {
      if (ct > n)
        acc
      else
        factSeqInner(n, ct * acc.head :: acc, ct + 1)
    }
  }

//  println(FactSeq.factSeq(4))
  val nums = (1 to 5).toList
  var n1: Int = 1
  var n2: Int = 1
  def compareNeighbors(xs: List[Int],
    compare: (Int, Int) => Int): List[Int] = {
    for (pair <- xs.sliding(2)) yield {
       n1 = pair.head
       n2 = pair(1)
      compare(n1, n2)
    }
  }.toList

  val x = compareNeighbors(nums, _ + _)
  println(x)
}
