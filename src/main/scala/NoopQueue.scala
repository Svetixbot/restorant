package com.thoughtworks

import com.thoughtworks.Restaurant.{FoodStatus, RequestId}


object NoopQueue extends Queue {
  override def askFor(food: Restaurant.Food) = Right(RequestId("such-id"))

  override def isItDoneYet(id: Restaurant.RequestId) = Right(FoodStatus("ok"))
}