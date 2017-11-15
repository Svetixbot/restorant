# Plan

## About

We are writing an api with 2 endpoints:

```sh
POST: .../imhungry?food=mushed&quantity=2
```
which will get back a requestId
```sh
GET: .../imhungry?requestid=123
```

## Challenge 1

### Implement Waiter functionality
Run the sbt console first,
```sh
sbt
```
and run the tests
```sh
testOnly com.thoughtworks.WaiterSpec
```

## Challenge 2

### Implement RestaurantHandler
Run the sbt console first,
```sh
sbt
```
and run the tests
```sh
testOnly com.thoughtworks.RestaurantHandlerSpec
```

## Challenge 3
### Add deliveryType field to request

Delivery type can only be 1 of Deliver or Pick up

## References
1. [unfiltered](http://unfiltered.ws)
2. [scalacheck](https://www.scalacheck.org)





