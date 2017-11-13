package com.thoughtworks

//import slick.driver.H2Driver.api._
import slick.jdbc.H2Profile.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

import com.thoughtworks.Restaurant.{ApiError, Food, FoodStatus, RequestId}


trait Queue {
  def askFor(food: Food): Either[ApiError, RequestId]
  def isItDoneYet(id: RequestId): Either[ApiError, FoodStatus]
}

object RestaurantQueue extends Queue {

  def askFor(food: Food): Either[ApiError, RequestId] = ???
  def isItDoneYet(id: RequestId): Either[ApiError, FoodStatus] = ???
 
  val connectionString = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
  val database = Database.forURL(connectionString, driver = "org.h2.Driver")

  // Schema for Food
  class FoodOrders(tag: Tag) extends Table[Food](tag, "FOOD") {
    def id = column[Int]("VALUE", O.PrimaryKey, O.AutoInc)
    def value = column[String]("VALUE")
    def count = column[Int]("COUNT")
    def * = (id.?, value, count) <> (Food.tupled, Food.unapply)
    def forInsert = (value, count) <> (
      { fromTuple: (String, Int) => Food(None, fromTuple._1, fromTuple._2) },
      { fromFood: Food => Some(fromFood.value -> fromFood.count) }
    )
  }

  def FoodOrders = TableQuery[FoodOrders]

  implicit class FoodOrdersExtensions(val food: Query[FoodOrders, Food, Seq]) extends AnyVal {
    def ofValue(value: String) =
      for (order <- FoodOrders if order.value === value) 
        yield order

      def forInsert = FoodOrders.map { food => (food.value, food.count) }
  }

  def initDb(): Unit = {
    val result = Seq(
      FoodOrders.schema.create,
      FoodOrders.forInsert ++= Seq(
        ("Pancakes", 2),
        ("Salad", 1),
        ("Pizza", 2)
      )
    ).map(database.run(_))

    Await.result(Future.sequence(result), 5.seconds)
  }
}
