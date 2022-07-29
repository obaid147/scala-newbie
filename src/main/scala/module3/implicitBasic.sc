import scala.language.implicitConversions

final case class Apple(weight: Int, color: String)
final case class Orange(weight: Int)

def function(orange: Orange): Int =
  orange.weight

def funct(apple1: Apple): Int = apple1.weight
//function(Apple(1, "Red")) wont work here

// takes apple returns orange
implicit def appleCanBeUsedAsOrange(apple: Apple): Orange =
  Orange(apple.weight)

/**implicit def OcanBeA(orang: Orange): Apple =
  Apple(orang.weight, "A")

funct(Orange(1))*/ // using OrangeAsApple

function(Apple(1, "Red")) // will work coz of implicit def

function( // takes Orange returns Int
  appleCanBeUsedAsOrange( // takes Apple return Orange
    Apple(
      // Apple is a class not an object
      // which means it does not return anything
      // constructor take parameters Int and String.
      2, "Blue"
    )
  )
)

final implicit class AppleWrapper(val apple: Apple){
  def toOrange: Orange =
    Orange(apple.weight)
}

//moving implicit above
// implicit def AppleWrapper(apple: Apple): AppleWrapper = {
//  new AppleWrapper(apple)
//}

function( // takes Apple returns AppleWrapper
  AppleWrapper( // takes Apple return Orange
    Apple(
      // Apple is a class not an object
      // which means it does not return anything
      // constructor take parameters Int and String.
      2, "Blue"
    )
  ).toOrange
)