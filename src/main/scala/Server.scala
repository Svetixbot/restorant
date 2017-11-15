package com.thougthworks

import com.thoughtworks.{RestaurantHandler, RestaurantQueue, SimpleDB}

/** embedded server */
object Server {
  def main(args: Array[String]): Unit = {
    unfiltered.netty.Server.http(8080)
      .handler(RestaurantHandler(RestaurantQueue()))
      .run()
  }
}
