package module10.demo.food.domain.api

import module10.demo.food.domain.internal.FoodDB

object FindFood{
  def lookupFood(name: String): Option[Dessert] = FoodDB.lookupDessert(name)
}