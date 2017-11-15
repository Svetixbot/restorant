package com.thoughtworks

object Restaurant {
  case class Food(value: String, count: Int)
  case class FoodStatus(status: String)
  case class RequestId(id: String)
  case class ApiError(value: String)
}
