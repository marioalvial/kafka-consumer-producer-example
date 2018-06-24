# kafka-consumer-producer-example

This project use a kafka-client lib to create a kafka producer and consumer.

## Requirements

For building and running the application you need:

- [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/)

## Running

First run this docker command to setup all you need to work with kafka e.g zookeeper, broker, etc...

```
docker run --rm -it \
           -p 2181:2181 -p 3030:3030 -p 8081:8081 \
           -p 8082:8082 -p 8083:8083 -p 9092:9092 \
           -e ADV_HOST=127.0.0.1 \
           landoop/fast-data-dev
```

Then just run the Main.kt class that's it.

