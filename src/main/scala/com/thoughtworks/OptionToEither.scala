package com.thoughtworks

object OptionToEither {
  def toEither[L, R](left: L, value: Option[R]): Either[L, R] =
    value match {
      case Some(v) => Right(v)
      case None => Left(left)
    }
}
