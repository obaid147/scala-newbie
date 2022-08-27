import module10.Logger.log

log("Hello World")

import module10.demo.food.domain.api._

val iceCream = IceCream("Strawberry")

def thirdLetterDessert(dessert: Dessert): Char = {
//  import iceCream.flavor // We don't need this as we can import instance
  import iceCream._ // imported instance
  import flavor._ // now we can use flavor
  charAt(3)
}

thirdLetterDessert(iceCream)
// returns index 3 char of Strawberry ie: a