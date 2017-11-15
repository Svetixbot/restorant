package com.thoughtworks

import org.scalacheck.Gen
import org.scalacheck.Gen.posNum

trait Arbitraries {

  val validHttpRequests = for {
    foodValue <- Gen.alphaStr suchThat (_.length > 0)
    count <- posNum[Int]
  } yield UnfilteredHttpRequest(Map("food" -> Seq(foodValue.toString),
    "count" -> Seq(count.toString)))

  val invalidHttpRequests = for {
    param1 <- Gen.alphaStr
    param2 <- Gen.alphaStr
    value1 <- Gen.alphaStr
    value2 <- Gen.alphaStr
  } yield UnfilteredHttpRequest(Map(param1 -> Seq(value1),
                                    param2 -> Seq(value2)))

  val validQuestion = for {
    requestId <- Gen.alphaStr suchThat(_.length > 0)
  } yield UnfilteredHttpRequest(Map("requestId" -> Seq(requestId)))


}
