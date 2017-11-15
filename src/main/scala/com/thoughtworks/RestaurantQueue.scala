package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}

case class RestaurantQueue() extends Queue {
  private val database = new SimpleDB()

  def askFor(food: Food): Either[ApiError, RequestId] = database.insert(food)
  def isItDoneYet(id: RequestId): Either[ApiError, String] = database.get(id)
}