package com.thougthworks

import com.thoughtworks.{NoopQueue, RestaurantHandler}
import com.thoughtworks.RestaurantQueue._

/** embedded server */
object Server {
  def main(args: Array[String]): Unit = {
    unfiltered.netty.Server.http(8080)
      .handler(RestaurantHandler(NoopQueue))
      .run()
      //.run({ _ => initDb() }, { srv => database.close() }) // TODO: Find out why table is not created
  }
}
