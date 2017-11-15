package com.thoughtworks

import java.io.{InputStream, Reader}

import unfiltered.request.HttpRequest

case class UnfilteredHttpRequest(values: Map[String, Seq[String]]) extends HttpRequest[Any] {
  override def inputStream: InputStream = ???

  override def reader: Reader = ???

  override def protocol: String = ???

  override def method: String = ???

  override def uri: String = ???

  override def parameterNames: Iterator[String] = ???

  override def parameterValues(param: String): Seq[String] = values.getOrElse(param, Nil)

  override def headerNames: Iterator[String] = ???

  override def headers(name: String): Iterator[String] = ???

  override def isSecure: Boolean = ???

  override def remoteAddr: String = ???
}