package com.thoughtworks

object Restaurant {
  case class Food(id: Option[Int], value: String, count: Int)
  case class FoodStatus(status: String)
  case class RequestId(id: String)
  case class ApiError(value: String)
}
