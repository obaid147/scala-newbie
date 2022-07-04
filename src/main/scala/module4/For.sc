/**
 *  for expression works on items that are held in some
 *  kind of container without worrying you about what
 *  that container is.
 *  Without yield block, foreach is used and Unit is the result type.
 */
// 1 using for print multiples up-to 10
for (i <- 1 to 10) println(i * i)
/**
 *  Whenever we use for loop like this we get back a unit
 *   when we do a for without a yield, it turns the call
     into a dot foreach over that collection. which is the 2nd and 4th loop here
 *  val lambda_exp = (variable: Type) => Transformation_Expression
 *  '=>' This is the 'goes to' function operator.
 *  Foreach also returns Unit.
 */
// 2 using foreach print multiples up-to 10
(1 to 10).foreach(i => println(i * i))

// 3 using for print multiples of 2 vars
for (i <- 1 to 3; j <- 1 to 3) println(i * j)

//4 using foreach print multiples of 2 vars
(1 to 3).foreach(i => (1 to 3).foreach(j => println(i * j)))

//5 using for with curley braces
for {
  i <- 1 to 3 // {} braces turn on semi-colon ie: newLine
  j <- 1 to 3
} {
  // multi-line block (looks weird without yield) --> ForYield.sc
  println(i * j)
}

// same as above
for {
  i <- 1 to 3 // {} braces turn on semi-colon ie: newLine
  j <- 1 to 3
}
  // multi-line block (looks weird without yield) --> ForYield.sc
  println(i * j)
