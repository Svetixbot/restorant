package com.thoughtworks

import com.thoughtworks.OptionToEither.toEither
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

  val quantity = (data.as.Int named "quantity").map(
    maybeQuantity => toEither(
      ApiError("Error while parsing quantity parameter"),
      maybeQuantity))


  val foodValue = (data.as.String named "food").map(
    maybeFood => toEither(
      ApiError("Error while parsing food parameter"),
      maybeFood
    )
  )

  /* This doesn't accumulate errors... */
  val parseRequest = for {
    maybeQuantity <- quantity
    maybeValue <- foodValue
  } yield for {
      qnt <- maybeQuantity
      food <- maybeValue
    } yield Food(food, qnt)

  val parseQuestion = (data.as.String named "requestId").map(
    maybeRequestId => toEither(
      ApiError("Error while parsing requestId"),
      maybeRequestId.map(RequestId)
    )
  )

}
