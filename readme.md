# What The Flow
This project was created to learn about reactive programming and compare Project Reactor and Kotlin Flow in a Spring WebFlux Application

SeatGeek is a website where you can find tickets to concerts, sports games, and other events
The APIs defined in this project call the [SeatGeek APIs](http://platform.seatgeek.com/) to get lists of venues that events are held at.

This is a work in progress and meant to be a tool for learning and improving so if you see any improvements feel free to submit a pull request!

## How to get started
You will need to have a local configuration file with the client id and client secret to call [SeatGeek APIs](http://platform.seatgeek.com/). 
Please contact me for client id and secret.

There are a few ways you can run this project
1. Through Intellij
* To override properties with a local file, you can add the following when editing your Run Configurations in Intellij and add 
`-Dspring.profiles.active=local -Dspring.config.location="file:///path/to/your/application-local.properties"`
* Click the play button that says: Run WhatTheFlowApplication

2. From command line
```
export SPRING_CONFIG_NAME=application-local
export SPRING_CONFIG_LOCATION=file:///path/to/your/location/
mvn clean install
java -jar target/what-the-flow-*.jar
```

Once you are running locally:

```
curl -X GET \
   http://localhost:8080/api/v1/kotlinFlowVenues \

curl -X GET \
   http://localhost:8080/api/v1/reactorVenues \

curl -X GET \
   http://localhost:8080/api/v1/kotlinFlowConcertVenues \

curl -X GET \
   http://localhost:8080/api/v1/reactorConcertVenues \
```
## Testing
To run unit tests:
`mvn test`
