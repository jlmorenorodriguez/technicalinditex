
## Swagger

[Enlace a Swagger](http://localhost:8080/swagger-ui/index.html#/Price/getPrice)

## Ejecucion de test

Usando la instruccion de maven,  

```
mvn test
```


La aplicacion usa una base de datos en memoria tipo H2, la cual al iniciarse con el comando 
```
mvn spring-boot:run

```
se autocarga con el insert que esta en main/resources/data.sql


## Tecnologías utilizadas
- Java 17
- Spring Boot 3.x
- H2 Database
- JUnit 5
- Maven
