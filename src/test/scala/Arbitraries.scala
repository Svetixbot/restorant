package com.thoughtworks

import com.thoughtworks.Restaurant.{Food, RequestId}
import org.scalacheck.Gen
import org.scalacheck.Gen.posNum

trait Arbitraries {

  def validHttpRequests = for {
    foodValue <- Gen.alphaStr suchThat (_.length > 0)
    count <- posNum[Int]
  } yield UnfilteredHttpRequest.POST(Map("food" -> Seq(foodValue.toString),
    "count" -> Seq(count.toString)))

  val invalidHttpRequests = for {
    param1 <- Gen.alphaStr
    param2 <- Gen.alphaStr
    value1 <- Gen.alphaStr
    value2 <- Gen.alphaStr
  } yield UnfilteredHttpRequest.POST(Map(param1 -> Seq(value1),
                                    param2 -> Seq(value2)))

  val validQuestion = for {
    requestId <- Gen.alphaStr suchThat(_.length > 0)
  } yield UnfilteredHttpRequest.GET(Map("requestId" -> Seq(requestId)))

  val invalidQuestion = for {
    param <- Gen.alphaStr
    value <- Gen.alphaStr
  } yield UnfilteredHttpRequest.GET(Map(param -> Seq(value)))

  val foodRequests = for {
    food <- Gen.alphaStr suchThat (_.length > 0)
    quantity <- Gen.posNum[Int]
  } yield Food(food, quantity)

  val questions = for {
    id <- Gen.alphaStr suchThat (_.length > 0)
  } yield RequestId(id)

}
