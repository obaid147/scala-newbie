package module10.demo.food.domain.internal

import module10.demo.food.domain.api.Dessert

import scala.collection.mutable

private[domain] class FoodDB{ //should be object to match in file api.FindFood.scala// Super-Package
  private[this] val desserts = mutable.Map.empty[String, Dessert]

  private[domain] def addDessert(name: String, dessert: Dessert): Unit = desserts.put(name, dessert)

  def lookupDessert(name: String): Option[Dessert] = desserts.get(name)
}

/**
 * private[domain] makes this private below demo.food.domain.
 * private[this] on desserts means only this specific instance can access it.
 */
