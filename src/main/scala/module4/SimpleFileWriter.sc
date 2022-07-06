import java.io._

/**
 *  RETURNING SOMETHING OTHER THAN UNIT
 */


/*class WriterOutput(writer: PrintWriter) {
  def write(s: String): Unit = writer.println(s)
  /**
  * println returns unit
  * Once we returned unit line 9, line 21, 22 and 23, out1.write will also return unit
 */
}
val ex1 = new PrintWriter(new File(
  "/home/shehzal/obaid_learning/learning/src/main/scala/module2/MyText.txt"
))

val out1 = new WriterOutput(ex1)

out1.write("Hello")
out1.write("to")
out1.write("you")
ex1.close()*/
/**
 * If you return this instead in the above example,
   you get a fluent API cheaply
 */
class WriterOutput2(writer: PrintWriter) {
  def write(s: String): WriterOutput2 = {
    writer.println(s)
    this // This returns the same reference, which means we can immediately another write on line 40
  }
}

val ex2 = new PrintWriter(new File(
  "/home/shehzal/obaid_learning/scala-newbie/src/main/scala/module2/MyText.txt"
))
val out2 = new WriterOutput2(ex2)
out2.write("Hello").write("to").write("you") // Here we are also ignoring the return type
ex2.close()

