# Using Docker Compose File

## Docker Compose File
Probably you have wondered why I added this as a new feature because this is what we are using in day-to-day life but we missed a feature when we are using this.
That’s running the docker-compose file when we are stating the application.
I have had several experiences I forgot to run the docker-compose file and then the application started to complain can not connect to the resources (Postgresql, MongoDB, Kafka ..etc). After that, I realize Ohh I forgot to run the docker-compose file.
I know this is many of your experiences as well.
To mitigate this issue spring boot team added that feature to the spring framework using spring-boot-docker-compose module.
Now you don’t want to worry about running docker-compose because the spring boot application itself takes care of it.

### How to configure
If we are following the default way of configuring the docker-compose file. we only need to do two things.

1. Add Dependency, You can be used the below dependency for Maven.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-docker-compose</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

2. Add a docker-compose file to the Spring Boot application root directory and it should have one of the below names,

- compose.yaml
- compose.yml
- docker-compose.yaml
- docker-compose.yml

- when the spring boot application contains the spring-boot-docker-compose dependency it will do the following steps:

- check the docker-compose file name above mention (it used the above order)
- Start the docker-compose file using docker compose up command
- Create a service connection bean for each supported container
- Stop the docker containers when the application starts unless you are not overriding the default lifecycle of the docker-compose

### How to use specific docker-compose file
If your docker-compose file is not in the application directory or that file name is different then you can use spring.docker.compose.file the property to specify the path to your custom docker-compose file.
You can use both an absolute and relative file path.

```properties
spring.docker.compose.file=./docker-compose/docker/local/docker-compose-local.yml
```

### How to override the lifecycle strategy
You can use the below property to change the default lifecycle strategy.

```properties
spring.docker.compose.lifecycle-management=start-and-stop
spring.docker.compose.start.command=start
spring.docker.compose.stop.command=down
spring.docker.compose.stop.timeout=1m
```

There have three lifecycle strategies,

- none: Do not start or stop the docker-compose file
- start-only: Start the docker-compose file when the application starts and leave it
- start-and-stop: Start Docker Compose when the application starts and stop it when the JVM exits (This is the default behavior)
For more details, you can use the [Spring boot Docker Container official documentation](https://docs.spring.io/spring-boot/docs/3.1.0/reference/html/features.html#features.docker-compose).

### How to configure application.properties file for docker configuration in test
You can set spring.docker.compose.skip.in-tests=false to enable the Docker Compose support in your tests
```properties
spring.docker.compose.skip.in-tests=false
spring.docker.compose.file=./docker/test/docker-compose-test.yml
```
