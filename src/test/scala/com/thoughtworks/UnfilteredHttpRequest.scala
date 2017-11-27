package com.thoughtworks

import java.io.{InputStream, Reader}

import unfiltered.netty.ReceivedMessage
import unfiltered.request.HttpRequest

case class UnfilteredHttpRequest(mthd: String, path: String, values: Map[String, Seq[String]]) extends HttpRequest[ReceivedMessage](ReceivedMessage(null, null, Nil)) {
  override def inputStream: InputStream = ???

  override def reader: Reader = ???

  override def protocol: String = ""

  override def method: String = mthd

  override def uri: String = path

  override def parameterNames: Iterator[String] = Iterator("food", "quantity")

  override def parameterValues(param: String): Seq[String] = values.getOrElse(param, Nil)

  override def headerNames: Iterator[String] = Iterator()

  override def headers(name: String): Iterator[String] = Iterator()

  override def isSecure: Boolean = false

  override def remoteAddr: String = ""
}

object UnfilteredHttpRequest {
  def POST(values: Map[String, Seq[String]]) = UnfilteredHttpRequest("POST", "/iamhungry", values)
  def GET(values: Map[String, Seq[String]]) = UnfilteredHttpRequest("GET", "/iamhungry", values)
}