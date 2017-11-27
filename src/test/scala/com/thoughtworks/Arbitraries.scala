package com.thoughtworks

import com.thoughtworks.Restaurant.{Food, RequestId}
import org.scalacheck.{Arbitrary, Gen}
import org.scalacheck.Gen.{alphaStr, posNum}

trait Arbitraries {

  def validFoodRequest = for {
    foodValue <- alphaStr suchThat (_.length > 0)
    count <- posNum[Int]
  } yield UnfilteredHttpRequest.POST(Map("food" -> Seq(foodValue.toString),
    "quantity" -> Seq(count.toString)))

  val validQuestion = for {
    requestId <- alphaStr suchThat(_.length > 0)
  } yield UnfilteredHttpRequest.GET(Map("requestId" -> Seq(requestId)))


  val invalidHttpRequests = for {
    param1 <- alphaStr
    param2 <- alphaStr
    value1 <- alphaStr
    value2 <- alphaStr
  } yield UnfilteredHttpRequest.POST(Map(param1 -> Seq(value1),
                                    param2 -> Seq(value2)))

  val food: Gen[Food] = for {
    food <- alphaStr suchThat (_.length > 0)
    quantity <- posNum[Int]
  } yield Food(food, quantity)

  val questions: Gen[RequestId] = for {
    id <- alphaStr suchThat (_.length > 0)
  } yield RequestId(id)

  implicit val arbHttpRequests: Arbitrary[UnfilteredHttpRequest] = Arbitrary(validFoodRequest)
}
