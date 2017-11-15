package com.thoughtworks

import java.util.UUID

import com.thoughtworks.Restaurant.{ApiError, Food, FoodStatus, RequestId}

import scala.collection.concurrent.TrieMap

class SimpleDB extends DB {

    private val database = TrieMap.empty[String, Food]

    private def generateId() = UUID.randomUUID().toString()

    override def insert(food: Food) = {
      val id = generateId()

      database.put(id, food) match {
        case Some(_) => Left(ApiError("this should not be possible"))
        case None => Right(RequestId(id))
      }
    }

    override def get(rq: RequestId) = {
      database.get(rq.id) match {
        case Some(food) => Right(FoodStatus(s"${food.count} of ${food.value} has been cooked"))
        case None => Left(ApiError("unknown request id"))
      }
    }
}
