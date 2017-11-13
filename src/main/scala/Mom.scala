import unfiltered.Cycle
import unfiltered.directives.Directives._
import unfiltered.directives._
import unfiltered.netty.cycle.Plan.Intent
import unfiltered.netty.{ServerErrorResponse, cycle}
import unfiltered.request.{GET, POST, Path}
import unfiltered.response.ResponseString
import unfiltered.request._
import unfiltered.response._
import unfiltered.directives._
import Directives._
import MomModel.Food


object Mom extends cycle.Plan
  with cycle.SynchronousExecution with ServerErrorResponse {

  override def intent = cookPlease orElse
                          areYouDoneYet

  val quantity: Directive[Any, Nothing, Int] = data.as.Required[Int] named "count"

  val foodValue: Directive[Any, Nothing, String] = data.as.Required[String] named "food"

  implicit val wish: Directive[Any, Nothing, Food] = for {
    q <- quantity
    v <- foodValue
  } yield Food(v, q)

  val cookPlease: Cycle.Intent[Any, Any] = Directive.Intent {
      case POST(Path("/food")) => for {
        w <- wish
        id <- momQueue.askFor(w)
      } yield ResponseString(
        s"you asked for: ${w.value} in: ${w.count}"
      )
    }

  val areYouDoneYet: Intent = {
    case GET(Path("/food")) => for {
      id <- idOfRequest
      status <- momQueue.isItDoneYet(id)
    } yield ResponseString(
      s"the status is: ${status}"
    )
  }
}
