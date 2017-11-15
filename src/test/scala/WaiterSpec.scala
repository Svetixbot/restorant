package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import unfiltered.directives.Result.Success

object WaiterSpec extends Properties("Waiter") with Arbitraries {

  property("parseValidRequest") = forAll(validHttpRequests) { request => {
//    collect(request){
      Waiter.parseRequest(request) ==
        Success(Right(Food(id = None,
          value = request.parameterValues("food").head,
          count = request.parameterValues("count").head.toInt)))
//      }
    }

  }

  property("parseInvalidRequest") = forAll(invalidHttpRequests) (request => {
    Waiter.parseRequest(request) == Success(Left(ApiError("oops")))
  })

  property("parseValidQuestion") = forAll(validQuestion) (question => {
    Waiter.parseQuestion(question) ==
      Success(Right(RequestId(
        id = question.parameterValues("requestId").head)))
  })

  property("parseInvalidQuestion") = forAll(invalidQuestion) (question => {
    Waiter.parseQuestion(question) == Success(Left(ApiError("oops")))
  })

}