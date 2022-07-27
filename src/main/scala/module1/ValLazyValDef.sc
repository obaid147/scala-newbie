// val we can say is EAGER, CACHED

val randomNumber = {
  println("Printing Random Number") // when i first run this it will print
  math.random()
}

// without calling it ran, val is like Future in scala
randomNumber
randomNumber
randomNumber
// when called it cached println and gave same random number
// whenever we tried to call it........................
///////////////////////////////////////////////////////

// lazy val is not EAGER,
// lazy val is evaluated the first time we call it

lazy val number = {
  println("printing a number")
  1
} // run this .sc file without calling number
// We cannot see anything running

number
// When we call it, then only we can see printing a number
// in console

///////////////////////////////////////////////////
// def is a way of writing methods in scala

def myName = {
  println("printing My Name")
  "Obaid"
}
myName
myName
// whatever is in the block is evaluated everytime we
// call myName method