package com.thoughtworks
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import unfiltered.response.ResponseString

object RestaurantHandlerSpec extends Properties("Handler") with Arbitraries {
  property("askForFoodHandler") = forAll(validHttpRequests) (request => {
    RestaurantHandler(NoopQueue).cookPlease(request) ==
      ResponseString("Your requestID is: such-id")
  })

  property("areYouDoneYet") = forAll(validQuestion) (question => {
    RestaurantHandler(NoopQueue).areYouDoneYet(question) ==
      ResponseString("Your requestID is: such-id")
  })


}
