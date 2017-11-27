package com.thoughtworks

import com.thoughtworks.Restaurant.{ApiError, Food, RequestId}
import org.specs2.{ScalaCheck, Specification}
import unfiltered.directives.Result.Success

class WaiterSpec extends Specification with ScalaCheck with Arbitraries {
  override def is =
    "Waiter spec".title ^
      s2"""
        Valid requests for food should be parsed $parseFood
        Invalid requests for food should give an api error $parseApiErrorForFood
        Valid questions should be parsed $parseQuestions
        Invalid questions should give an api error $parseApiErrorForQuestion
      """

  def parseFood = prop((request: UnfilteredHttpRequest) => {
    Waiter.parseRequest(request) mustEqual
      Success(Right(Food(
        food = request.parameterValues("food").head,
        quantity = request.parameterValues("quantity").head.toInt)))
  }).setGen(validFoodRequest)

  def parseApiErrorForFood = prop((request: UnfilteredHttpRequest) => {
    Waiter.parseRequest(request) mustEqual
      Success(Left(ApiError("Error while parsing quantity parameter")))
  }).setGen(invalidPostRequest)

  def parseQuestions = prop((question: UnfilteredHttpRequest) => {
    Waiter.parseQuestion(question) mustEqual
      Success(Right(RequestId(id = question.parameterValues("requestId").head)))
  }).setGen(validQuestion)

  def parseApiErrorForQuestion = prop((question: UnfilteredHttpRequest) => {
    Waiter.parseQuestion(question) mustEqual Success(Left(ApiError("Error while parsing requestId")))
  }).setGen(invalidGetRequest)
}
