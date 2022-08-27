package module10.demo.drink.domain.internal


import module10.demo.food.domain.api.{Dessert, IceCream}
import module10.demo.drink.domain.api.Drink

private[domain] object ParingDB{
  private[this] val drinkParis = Map[Dessert, Drink](
    IceCream("Vanilla") -> Drink("Coke", 1990, "SoftDrink"))

  def pairDrinkWithDessert(dessert: Dessert): Option[Drink] = drinkParis.get(dessert)
}
