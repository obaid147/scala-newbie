package module10.demo.food.domain.api
import module10.demo.food.domain.allFoods

class FindFood{
  def lookupFood(name: String): Option[Dessert] = allFoods.lookupDessert(name)
//  def lookupFood(name: String): Option[Dessert] = FoodDB.lookupDessert(name)
}
