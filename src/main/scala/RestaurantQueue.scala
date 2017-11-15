package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, FoodStatus, RequestId}

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.control.Exception.allCatch

case class RestaurantQueue() extends Queue {
  private val database = new SimpleDB()

  def askFor(food: Food): Either[ApiError, RequestId] = database.insert(food)
  def isItDoneYet(id: RequestId): Either[ApiError, FoodStatus] = database.get(id)
}