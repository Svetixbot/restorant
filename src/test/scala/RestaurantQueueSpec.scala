import com.thoughtworks.Restaurant.ApiError
import com.thoughtworks.WaiterSpec.{invalidHttpRequests, property}
import com.thoughtworks.{Arbitraries, RestaurantQueue, Waiter}
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import unfiltered.directives.Result.Success

object RestaurantQueueSpec extends Properties("Queue") with Arbitraries {

  property("askForFood:creates a request") = forAll(foodRequests) (food => {
    RestaurantQueue(???).askFor(food) == ???
  })

  property("isItDoneYet: gets back with a status") = forAll(questions) (question => {
    RestaurantQueue(???).isItDoneYet(question) == ???
  })

}
