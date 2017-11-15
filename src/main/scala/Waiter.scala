package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}
import unfiltered.directives.Directives._
import unfiltered.directives.data

object Waiter {
  val quantity = data.as.Int named "count"
  val foodValue = data.as.String named "food"

  val maybeFood: (Option[Int], Option[String]) => Either[ApiError, Food] =
    (maybeQuantity, maybeValue) => (maybeQuantity, maybeValue) match {
      case (Some(q), Some(v)) => Right(Food(None, v, q))
      case _ => Left(ApiError("oops"))
    }

  val parseRequest = for {
    maybeQuantity <- quantity
    maybeValue <- foodValue
  } yield maybeFood(maybeQuantity, maybeValue)

  val parseQuestion = {
    for {
      v <- data.as.String named "requestId"
    } yield v match {
      case Some(value) => Right(RequestId(value))
      case _ => Left(ApiError("oops"))
    }
  }
}
