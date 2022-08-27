import module10.Logger
import module10.demo.drink.{domain => drinkdomain}
import module10.demo.food.{domain => fooddomain}

Logger.log("Renaming / Aliasing")

import fooddomain.api.{Jello => jelly, IceCream}
IceCream("ABC")
jelly("green")
//jello("green") Compile Error Not found

import drinkdomain.api._
Drink("Foo", 1890, "Mountain Dew")