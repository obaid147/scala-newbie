val l = List(1,2,3,4)
l.filter(_ % 2 == 0)
l.filterNot(_ % 2 == 0)

val line = "abc def ghi"
val letters = line.toLowerCase.filterNot(x => x == ' ').toSeq
val letters2 = line.toLowerCase.filter(x => x == ' ').toSeq
val grouped = letters.groupBy(identity)


def idenetityx[A](x: A) = x

idenetityx(10)
idenetityx(true)