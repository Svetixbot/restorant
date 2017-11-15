package com.thoughtworks

import unfiltered.directives._
import unfiltered.netty.cycle.Plan.Intent
import unfiltered.netty.{ServerErrorResponse, cycle}
import unfiltered.request.{GET, POST, Path}
import unfiltered.response.ResponseString

@io.netty.channel.ChannelHandler.Sharable
case class RestaurantHandler(queue: Queue) extends cycle.Plan
  with cycle.SynchronousExecution with ServerErrorResponse {

  override def intent = areYouDoneYet orElse cookPlease

  val cookPlease: Intent = ???

  val areYouDoneYet: Intent = ???


}
