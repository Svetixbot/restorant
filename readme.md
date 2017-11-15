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

### Implement RestaurantQueue
Run the sbt console first,
```sh
sbt
```
and run the tests
```sh
testOnly com.thoughtworks.RestaurantQueueSpec
```

## Challenge 3

### Implement RestaurantHandler
Run the sbt console first,
```sh
sbt
```
and run the tests
```sh
testOnly com.thoughtworks.RestaurantHandlerSpec
```

## Challenge 4
### Add deliveryType field to request

Delivery type can only be 1 of Deliver or Pick up

## References
list to unfiltered
scalacheck



TODO
1. Queue functions should return Future
2. Rename project and endpoints
3. Write specs for Restaurant handler
4. Write specs for Restaurant queue
5. Reuse the insert statement in init db
6. Write specs for parseQuestions
7. Implemnent challenge 4 (how to writes parsers for enums)
8. DB should return generated ID, replace DB with MAP
9. Ty to go through challenges.
10. move files into related package
11. Status is not implemented.

Priorities:
8 J
5 J
3 S
4 S
6 S
2
7
1 J





