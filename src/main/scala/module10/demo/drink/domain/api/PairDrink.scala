package module10.demo.drink.domain.api
//1
import module10.demo.food._ // once we bring food._ we can use the nelow import
/**import module10.demo.food._ brings in the domain package from there*/

//2
import module10.demo.food.domain.api.Dessert // because of the above food._ we can bring in Dessert

//3
/**To import domain.Logger, we need to use import _root_. to force Scala to
go back to the root of the package hierarchy*/

//4
import module10.demo.drink.domain.internal.ParingDB
/**import domain.internal.PairingDB will not work, since that thinks you now
mean starting from domain in demo.food. We have to use
import module10.demo.wine.domain.internal.PairingDB */

/**import module10.demo.food.domain.api.Dessert references that domain from demo.food*/


/*object PairDrink{ // imported log at file level
  def pairDrinkWithDessert(dessert: Dessert): Option[Drink] = {
    Logger.log(s"Attempting to pair $dessert")
    ParingDB.pairDrinkWithDessert(dessert)
  }
}*/

object PairDrink{ // importing log at object level
  import _root_.module10.Logger.log
  def pairDrinkWithDessert(dessert: Dessert): Option[Drink] = {
    log(s"Attempting to pair $dessert")
    ParingDB.pairDrinkWithDessert(dessert)
  }
}

/**
 * Scala can import anything, from anywhere, at any point in your code
    Importing from a package is the most common, but import from objects
    and instances is also useful
E.g. to import the log method from Logger directly

 * Note that the import is within the PairWine object body, log is only in scope
inside PairDrink
You can import and scope to a single method, or even an arbitrary code
block in {}s if desired
 */