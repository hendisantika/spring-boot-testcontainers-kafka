# spring-boot-testcontainers-kafka

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-testcontainers-kafka/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-testcontainers-kafka/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.2-brightgreen?logo=springboot)
![Dependabot](https://img.shields.io/badge/Dependabot-enabled-blue?logo=dependabot)

Sample Spring Boot application that publishes messages to Apache Kafka and uses
[Testcontainers](https://testcontainers.com/) to spin up a real Kafka broker for local development and tests.

## Tech Stack

- Java 25
- Spring Boot 4.1.2 (Web, Validation, Spring for Apache Kafka)
- Testcontainers (Kafka)
- springdoc-openapi (Swagger UI)
- Lombok
- Maven (via Maven Wrapper)

## Requirements

- JDK 25 (e.g. [Eclipse Temurin](https://adoptium.net/))
- Docker (required by Testcontainers and `compose.yaml`)
- Maven 3.9+ — or simply use the bundled `./mvnw`

## Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-testcontainers-kafka.git`
2. Navigate to the folder: `cd spring-boot-testcontainers-kafka`
3. Make sure Docker is running and `java -version` reports 25
4. Run the application: `./mvnw clean spring-boot:run`
5. Open your favorite browser: http://localhost:8080/swagger-ui

## Build & Test

```shell
./mvnw clean verify
```

## Usage

Shell:

```shell
curl -X 'GET' \
  'http://localhost:8080/kafka/topic/Testing%201' \
  -H 'accept: application/json'
Finish sending [Testing 1], Check log to know the result%
```

Swagger UI

![Swagger UI](img/Swagger%20UI.png "Swagger UI")

## CI/CD

GitHub Actions workflow [`maven.yml`](.github/workflows/maven.yml) runs on every push and pull request to `main`:

- **build** — sets up Temurin JDK 25 and runs `./mvnw -B verify`.
- **dependency-graph** — on pushes to `main` only, submits the Maven dependency graph to GitHub
  to improve Dependabot alerts.

## Dependency Updates

[Dependabot](.github/dependabot.yml) keeps dependencies up to date:

| Ecosystem      | Schedule                      | Grouping                                                                         |
|----------------|-------------------------------|----------------------------------------------------------------------------------|
| Maven          | Daily, 05:00 Asia/Jakarta     | Spring Boot, Spring, Testcontainers, springdoc, Maven plugins, minor & patch    |
| GitHub Actions | Daily, 05:00 Asia/Jakarta     | All actions in a single PR                                                       |
| Docker Compose | Weekly (Monday), 05:00 WIB    | —                                                                                |

All Dependabot PRs are labelled `dependencies` and use conventional commit prefixes
(`build(deps)`, `ci(deps)`, `build(docker)`).
