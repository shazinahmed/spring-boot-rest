# REST Services with Spring Boot

The project will run using an embedded Tomcat server and the methods are exposed as REST services.

## Running the application

**System requirements**

- Java 8
- Maven 3.x.x

To start the application

    mvn package && java -jar target/spring-rest-0.0.1-SNAPSHOT.jar


Once the application is running, the following REST services are available:


* **Adding an item to store**

    http://localhost:8080/store/add/{ItemName}/{Price}

* **Adding an item to cart**

    http://localhost:8080/cart/add/{ItemName}/{Quantity}
    
* **Getting cart items**

    http://localhost:8080/cart/items
    
* **Getting cart total**

    http://localhost:8080/cart/total

    
###Notes
- Instead of a database, and in memory hashmap has been used to store data. Hence, on each restart data will get erased.
