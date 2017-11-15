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

  val cookPlease: Intent = Directive.Intent {
    case POST(Path("/food")) => for {
      foodRequest <- Waiter.parseRequest
    } yield {
      val queued = for {
        what <- foodRequest
        id <- queue.askFor(what)
      } yield id

      queued.fold(error => ResponseString(s"Sorry, there was an ${error.value}"),
                  rq => ResponseString(s"Your requestID is: ${rq.id}"))
    }
  }

  val areYouDoneYet: Intent = Directive.Intent {
    case GET(Path("/food")) => for {
      maybeId <- Waiter.parseQuestion
    } yield {
      val status = for {
        id <- maybeId
        status <- queue.isItDoneYet(id)
      } yield status

      status.fold(error => ResponseString(s"Sorry, there was an ${error.value}"),
        st => ResponseString(s"Your requestID is: ${st.status}"))
    }
  }


}
