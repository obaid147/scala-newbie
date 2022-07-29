package module1

object ValAndVarDiff extends App {
  var x = 10
  try {
    val y = x = 20
  } catch{
    case x: Exception => x
  }
}
