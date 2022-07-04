class Ws2{
  private val classSecretKey = 123
//  override def toString: String =
    println(s"\nObject secret key:-${Ws2.secretObjectKey}")
}

object Ws2{
  private val secretObjectKey: Int = 786
  def apply() = {

    val obj = new Ws2
    val returnSecret = obj.classSecretKey
    println(s"Class secret key:- $returnSecret")

  }
}

Ws2.apply()