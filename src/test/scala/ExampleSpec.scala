package com.example

import java.io.{InputStream, Reader}

import com.thoughtworks.Waiter
import org.specs2.mutable.Specification
import okhttp3._
import unfiltered.directives.Result
import unfiltered.directives.Result.Success
import unfiltered.request.HttpRequest

object ExampleSpec extends Specification {

  case class ttt() extends HttpRequest[Any] {
    override def inputStream: InputStream = ???

    override def reader: Reader = ???

    override def protocol: String = ???

    override def method: String = ???

    override def uri: String = ???

    override def parameterNames: Iterator[String] = Iterator("food", "count")

    override def parameterValues(param: String): Seq[String] = Seq("fddd", "1233")

    override def headerNames: Iterator[String] = ???

    override def headers(name: String): Iterator[String] = ???

    override def isSecure: Boolean = ???

    override def remoteAddr: String = ???
  }

  "The example app" should {
    "serve unfiltered text" in {
      val rq: HttpRequest[Any] = ttt()
      val thing: Result[Nothing, Option[String]] =  Waiter.foodValue(rq)
      thing mustEqual Success(Some("fddd"))
    }
  }
}
