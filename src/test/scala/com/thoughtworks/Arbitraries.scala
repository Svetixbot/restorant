package com.thoughtworks

import com.thoughtworks.Restaurant.{Food, RequestId}
import org.scalacheck.Gen.{alphaStr, posNum}

trait Arbitraries {

  def validHttpRequests = for {
    foodValue <- alphaStr suchThat (_.length > 0)
    count <- posNum[Int]
  } yield UnfilteredHttpRequest.POST(Map("food" -> Seq(foodValue.toString),
    "count" -> Seq(count.toString)))

  val invalidHttpRequests = for {
    param1 <- alphaStr
    param2 <- alphaStr
    value1 <- alphaStr
    value2 <- alphaStr
  } yield UnfilteredHttpRequest.POST(Map(param1 -> Seq(value1),
                                    param2 -> Seq(value2)))

  val validQuestion = for {
    requestId <- alphaStr suchThat(_.length > 0)
  } yield UnfilteredHttpRequest.GET(Map("requestId" -> Seq(requestId)))

  val invalidQuestion = for {
    param <- alphaStr
    value <- alphaStr
  } yield UnfilteredHttpRequest.GET(Map(param -> Seq(value)))

  val foodRequests = for {
    food <- alphaStr suchThat (_.length > 0)
    quantity <- posNum[Int]
  } yield Food(food, quantity)

  val questions = for {
    id <- alphaStr suchThat (_.length > 0)
  } yield RequestId(id)

}
