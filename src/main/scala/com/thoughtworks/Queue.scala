package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}


trait Queue {
  def askFor(food: Food): Either[ApiError, RequestId]
  def isItDoneYet(id: RequestId): Either[ApiError, String]
}
