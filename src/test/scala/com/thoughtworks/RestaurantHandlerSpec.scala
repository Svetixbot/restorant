package com.thoughtworks

import org.specs2.{ScalaCheck, Specification}
import unfiltered.response.ResponseString

object RestaurantHandlerSpec extends Specification with ScalaCheck with Arbitraries {
  override def is = "Request handler spec".title ^
    s2"""
      valid food request should respond with request id $validFoodHandler
      valid food status check should respond with string $validFoodStatusCheck
      invalid food request should respond with error string $invalidFoodHandler
      invalid food status check should respond with string $invalidFoodStatusCheck
    """

  def validFoodHandler = prop((request: UnfilteredHttpRequest) => {
    RestaurantHandler(NoopQueue).cookPlease(request) mustEqual
      ResponseString("Your requestID is: such-id")
  }).setGen(validFoodRequest)

  def validFoodStatusCheck = prop((request: UnfilteredHttpRequest) => {
    RestaurantHandler(NoopQueue).areYouDoneYet(request) mustEqual
      ResponseString("Your status is: ok")
  }).setGen(validQuestion)

  def invalidFoodHandler = prop((request: UnfilteredHttpRequest) => {
    RestaurantHandler(NoopQueue).cookPlease(request) mustEqual
      ResponseString("Error while parsing quantity parameter")
  }).setGen(invalidPostRequest)

  def invalidFoodStatusCheck = prop((request: UnfilteredHttpRequest) => {
    RestaurantHandler(NoopQueue).areYouDoneYet(request) mustEqual
      ResponseString("Error while parsing requestId")
  }).setGen(invalidGetRequest)
}
