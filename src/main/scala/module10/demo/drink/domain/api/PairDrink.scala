package module10.demo.drink.domain.api

import module10.demo.food._ // once we bring food._ we can use the nelow import
/**import module10.demo.food._ brings in the domain package from there*/
import domain.api.Dessert // because of the above food._ we can bring in Dessert

import _root_.module10.Logger
/**To import domain.Logger, we need to use import _root_. to force Scala to
go back to the root of the package hierarchy*/

import module10.demo.drink.domain.internal.ParingDB
/**import domain.internal.PairingDB will not work, since that thinks you now
mean starting from domain in demo.food. We have to use
import module10.demo.wine.domain.internal.PairingDB */

/**import module10.demo.food.domain.api.Dessert references that domain from demo.food*/


object PairDrink{
  def pairDrinkWithDessert(dessert: Dessert): Option[Drink] = {
    Logger.log(s"Attempting to pair $dessert")
    ParingDB.pairDrinkWithDessert(dessert)
  }
}