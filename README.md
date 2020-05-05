# Spring Cloud Stream using Kafka and Avro Schema Registry

This is a sample Spring Cloud Stream application for producing and consuming messages through a
Kafka topic. Besides, the messages are (de)serialized as Avro.

## Running the application

First of all, a stack with Zookeeper, Kafka, and a Schema Registry must be started up. So run the
following command:
```bash
docker-compose up -d
```

After that, we can start the application itself:
```bash
./gradlew bootRun
```

## Testing

This application exposes an endpoint for publishing messages to the topic. The below cURL command
shows how to call it:
```bash
curl -X POST \
    http://localhost:8080/api/v1/messages \
    -H 'Content-Type: application/json' \
    -d '{"message":"Kafka is awesome!"}'
```

The published messages will be consumed and logged in the application console.

## Changing the AVRO schema

In order to evolve the AVRO schema, change the `.avsc` file and regenerate the Java classes by 
running the command:
```bash
./gradlew generateAvroJava
```
