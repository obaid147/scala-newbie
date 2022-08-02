def matchTuples(tup: (Int, Boolean, String)): String = tup match {
  case (1, flag, string)  => s"a 1 followed by $flag and $string"
  case (i, true, "Obaid") => s"a true Obaid with int $i"
  case (a, b, c)          => s"Some other tuple int $a, flag $b, string $c"
}

matchTuples((1, false, "Sally")) // s"a 1 followed by false and Sally"
matchTuples((1, true, "Harry")) // s"a 1 followed by true and Harry"
matchTuples((2, true, "Obaid")) // s"a true Obaid with int 2"
matchTuples((2, false, "Fred")) // s"Some other tuple int 2, flag false, string Fred"

/**
 * true is a keyword, so there is no confusion about load or constant match
    there, it's a constant */