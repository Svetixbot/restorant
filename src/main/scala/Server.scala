package com.thougthworks

import com.thoughtworks.{DB, RestaurantHandler, RestaurantQueue}

/** embedded server */
object Server {
  def main(args: Array[String]): Unit = {
    val database = DB.create
    unfiltered.netty.Server.http(8080)
      .handler(RestaurantHandler(RestaurantQueue(database)))
      .run({ _ => DB.InitDB(database) }, { _ => DB.close(database) })
  }
}
