package com.thoughtworks

import com.thoughtworks.Restaurant.Food
import slick.dbio.DBIO
import slick.jdbc.H2Profile
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object DB {
  val connectionString = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"

  val create = Database.forURL(connectionString, driver = "org.h2.Driver")

  def close(database: H2Profile.backend.DatabaseDef) = database.close()

  var uniqueId: Int = 0

  object InitDB {
    def insert(c: Food): DBIO[Int] =
      sqlu"insert into food(id, value, count) values (1, ${c.value}, ${c.count})"

    val schema : DBIO[_] =
      sqlu"""create table food(
        id int not null,
        value varchar not null,
        count varchar not null)"""

    def apply(database: H2Profile.backend.DatabaseDef): Unit = {
      Await.result( for {
        _ <- database.run(schema)
        res <- database.run(insert(Food(None, "tea", 2)))
      } yield res, 5.seconds)
    }
  }


}
