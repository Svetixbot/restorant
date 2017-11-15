package com.thoughtworks

import org.scalacheck.Gen
import org.scalacheck.Gen.posNum

trait Arbitraries {

  val validHttpRequests = for {
    foodValue <- Gen.alphaStr suchThat (_.length > 0)
    count <- posNum[Int]
  } yield UnfilteredHttpRequest(Map("food" -> Seq(foodValue.toString),
    "count" -> Seq(count.toString)))

}
