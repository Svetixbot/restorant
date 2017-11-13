import MomModel.{Food, FoodStatus, RequestId}

trait MomQueue {
  def askFor(food: Food): Either[Error, RequestId]
  def isItDoneYet(id: RequestId): Either[Error, FoodStatus]
}
