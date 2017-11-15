# Plan

## About

We are writing an api with 2 endpoints:

```sh
POST: .../imhungry?food=mushed&quantity=2
```
which will get back a requestId
```sh
GET: .../imhungry?requestId=123
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

## How to run

```sh
sbt run
```

### Test it with curl
POST:
```sh
curl -X POST -d food=cheese -d quantity=2 localhost:8080/imhungry
```
expected:

```sh
Your requestID is: b39126af-70a7-4c7c-a88a-a5e627d35635Y
```
GET:
```sh
curl localhost:8080/imhungry?requestId=b39126af-70a7-4c7c-a88a-a5e627d35635
```
expected:
```sh
Your status is: 2 of cheese has been cooked
```

## References
1. [unfiltered](http://unfiltered.ws)
2. [scalacheck](https://www.scalacheck.org)





