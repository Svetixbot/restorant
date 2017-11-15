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
list to unfiltered
scalacheck



TODO
2. Rename project and endpoints
7. Implemnent challenge 4 (how to writes parsers for enums)
9. Ty to go through challenges.






