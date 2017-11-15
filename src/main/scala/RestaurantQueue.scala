package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, FoodStatus, RequestId}

case class RestaurantQueue() extends Queue {
  private val database = new SimpleDB()

  def askFor(food: Food): Either[ApiError, RequestId] = database.insert(food)
  def isItDoneYet(id: RequestId): Either[ApiError, FoodStatus] = database.get(id)
}