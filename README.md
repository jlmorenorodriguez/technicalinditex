# Inditex Test API

Esta es una aplicación desarrollada con **Spring Boot** que provee un endpoint REST para consultar precios de productos según las reglas y la base de datos en memoria proporcionada.

## Descripción

El servicio recibe como parámetros de entrada:
- **Fecha de aplicación**
- **Identificador de producto**
- **Identificador de cadena**

Y devuelve:
- **Identificador de producto**
- **Identificador de cadena**
- **Tarifa a aplicar**
- **Fechas de aplicación**
- **Precio final**

- 
## Swagger
[Enlace a Swagger](http://localhost:8080/swagger-ui/index.html#/Price/getPrice)
## BD
Para acceder al panel de control de la BD 
[H2 Console](http://localhost:8080/h2-console)

## Ejecucion de test

Usando la instruccion de gradle,  

```
./gradlew test
```

## Ejecucion de la app

La aplicacion usa una base de datos en memoria tipo H2, la cual al iniciarse con el comando 
```
./gradlew build

./gradlew bootRun

```
se autocarga con el insert que esta en main/resources/data.sql


## Tecnologías utilizadas
- Java 17
- Spring Boot 3.x
- H2 Database
- JUnit 5
- Gradle
