val chars = List.range('a', 'h')

val idx1: Seq[Int] = chars.indices // index range seq{int]
val idx2: Range = chars.indices // index range

chars.zip(idx2) // zipping index and chars

val zipped = chars.zipWithIndex// zipping index and chars

zipped.unzip // List[Char] List[Int]