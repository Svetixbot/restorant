package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, FoodStatus, RequestId}
import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.control.Exception.allCatch

case class RestaurantQueue(database: H2Profile.backend.DatabaseDef) extends Queue {

  def askFor(food: Food): Either[ApiError, RequestId] = Right(RequestId(""))

  def isItDoneYet(id: RequestId): Either[ApiError, FoodStatus] = ???
}