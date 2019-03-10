# Movie browsing app

This is a sample Springboot app with following implementations:

## Implementations
1. Spring boot

2. Flyway (DB migration tool)

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/mohitanchan/movies-browser.git
```

**2. Create Postgresql database**
```bash
create database movies
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your postgressql installation

**4. Build and run the app using maven**

```bash
cd movies
mvn package
java -jar target/movies-0.0.1-SNAPSHOT.jar
```

You can also run the app without packaging it using -

```bash
mvn spring-boot:run
```