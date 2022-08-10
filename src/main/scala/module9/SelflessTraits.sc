trait Logging{
  def error(msg: String): Unit = println(s"Error:- $msg")
  def info(msg: String): Unit = println(s"Info:- $msg")
}

// -------Choose trait mixin
class Process1 extends Logging{
  def doIt(): Unit ={
    info("Checking the cell structure")
    error("It's all gone pear shaped")
  }
}
val p1 = new Process1
p1.doIt()

// -------OR Choose import
object Logging extends Logging
//     object          trait

class Process2{
  import Logging.{info,error} // importing object
  def doIt(): Unit = {
    info("Checking the cell structure")
    error("It's all gone pear shaped")
  }
}
val p2 = new Process2
p2.doIt()