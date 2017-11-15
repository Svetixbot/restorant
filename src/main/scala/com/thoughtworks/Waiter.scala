package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}
import unfiltered.directives.Directives._
import unfiltered.directives.{Directive, data}

object Waiter {
  val parseRequest: Directive[Any, Nothing, Either[ApiError, Food]] = ???

  val parseQuestion: Directive[Any, Nothing, Either[ApiError, RequestId]] = ???
}
