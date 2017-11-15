package com.thoughtworks

import com.thoughtworks.Restaurant.Food
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import unfiltered.directives.Result.Success

object WaiterSpec extends Properties("Waiter") with Arbitraries {

  property("parseRequest") = forAll(validHttpRequests) { request => {
//    collect(request){
      Waiter.parseRequest(request) ==
        Success(Right(Food(id = None,
          value = request.parameterValues("food").head,
          count = request.parameterValues("count").head.toInt)))
//      }
    }

  }

}
