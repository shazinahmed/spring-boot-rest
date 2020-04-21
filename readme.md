# REST Services with Spring Boot

The project will run using an embedded Tomcat server and the methods are exposed as REST services.

## Running the application

**System requirements**

- Java 8
- Maven 3.x.x
- Docker (if running with docker)

To start the application normally

    mvn package
    java -jar target/spring-rest-0.0.1-SNAPSHOT.jar
    
To start the application with docker

        docker container run -p 8080:8080 -d --name <CONTAINER NAME> shazahmed/spring-boot-rest


Once the application is running, the following REST services are available:


* **Adding an item to store**

  POST  http://localhost:8080/store/add

* **Adding an item to cart**

  POST  http://localhost:8080/cart/add
    
* **Getting cart items**

  GET  http://localhost:8080/cart/items
    
* **Getting cart total**

   GET http://localhost:8080/cart/total

    
###Notes
- Instead of a database, and in memory hashmap has been used to store data. Hence, on each restart data will get erased.

##TODO
- Add Swagger
