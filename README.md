# demo-order-taking

1. Requires [docker](https://docs.docker.com/get-docker/) and [compose](https://docs.docker.com/compose/install/)
2. Parameterized using variables in the [`.env`](.env) file
3. Up the project using command:
```
docker compose up -d
```
## Postman Collection for Integration Tests
- 'Order_Service_Integration_tests.postman_collection.json'

### Technologies

- Java 17
- Gradle
- Kafka
- Kafdrop
- Postgres
- Spring Boot 3.1.4
- Spring Cloud
- Eureka
- Keycloak
- Zookeeper

| App | Port | Username | Password
|-|-|-|-
| Keycloak | 8080 | `admin` | `keycloak`

## What hasn't been done
- Saving orders to the database and changing their status after processing
- Sending letters, you need to create another application
- Keylock is not connected to Spring security applications
