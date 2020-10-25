# desafio-walmart-spring

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

-Linux install maven:

```shell
sudo apt update
sudo apt install maven
```
-Mac install maven:

```shell
brew update
brew install maven
```
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.spring.walmart.desafio.DesafioApplication` class from your IDE.

Required env variables:

```javascript
MONGO_DATABASE=desafio;
MONGO_URI=mongodb+srv://user:password@url/desafio?retryWrites=true&w=majority;
ENV=dev
```

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Test
```shell
mvn test
```

For verifying test coverage go to target/site/jacoco-ut/index.html.

