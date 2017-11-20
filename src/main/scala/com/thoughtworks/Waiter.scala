package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}
import unfiltered.directives.Directives._
import unfiltered.directives.data

object Waiter {


   /**
    * 1. Check out data.as.Int named "quantity"
    * `named` is a function which gives you back directive.
    * 2. Directives have monadic behaviour.
    * Which means you can compose them together.
    * How?
    * Check out flatMap or for comprehension?
    * 3. One more challange: how to convert Option into Either?
    * Check out pattern matching or fold function.
    * */

  val quantity = data.as.Int named "quantity"
  val foodValue = data.as.String named "food"

  val maybeFood: (Option[Int], Option[String]) => Either[ApiError, Food] =
    (maybeQuantity, maybeValue) => (maybeQuantity, maybeValue) match {
      case (Some(q), Some(v)) => Right(Food(v, q))
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
