package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, FoodStatus, RequestId}

trait DB {
  def insert(food: Food): Either[ApiError, RequestId]
  def get(request: RequestId): Either[ApiError, FoodStatus]
}
