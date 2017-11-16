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

  /*
	1. Check out the signatures first.
	2. Directive.Intent takes partial function as an input.
		That's where we can pattern match on the Path
			`case GET(Path("/suchPath")) => ???`
  */
  val cookPlease: Intent = Directive.Intent {
  	???
  }

  val areYouDoneYet: Intent = Directive.Intent {

  }


}
