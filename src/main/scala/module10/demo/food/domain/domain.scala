package module10.demo.food

import module10.demo.food.domain.api.IceCream
import domain.internal.{FoodDB => FDB}

package object domain{
  lazy val allFoods: FDB = {
    val foodDB = new FDB
    foodDB.addDessert("Vanilla Ice cream", IceCream("Vanilla"))
    foodDB
  }
}

/**
 * We cannot put val def outside a class, object, traits in scala file.
 * We used to easily work with worksheets but not with scala files.
 * Package Object can work for us the same way as worksheet where
 * We can keep our val's def's at top level.
 */
