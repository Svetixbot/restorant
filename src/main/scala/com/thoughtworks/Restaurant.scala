package com.thoughtworks

object Restaurant {
  case class Food(food: String, quantity: Int)
  case class RequestId(id: String)
  case class ApiError(value: String)
}
