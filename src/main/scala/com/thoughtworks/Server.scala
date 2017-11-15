package com.thoughtworks

/** embedded server */
object Server {
  def main(args: Array[String]): Unit = {
    unfiltered.netty.Server.http(8080)
      .handler(RestaurantHandler(RestaurantQueue()))
      .run()
  }
}
