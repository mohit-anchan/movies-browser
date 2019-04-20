
# Movie browsing app

This is a sample Spring Boot app with following implementations:  

## Implementations
1. Spring boot

2. Flyway (DB migration tool)

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/mohitanchan/movies-browser.git
```

**2. Create PostgreSQL database**
```bash
create database movies
```

**3. Setup PostgreSQL properties**

Instead of storing the DB properties in plain text within the source code, it would be much more secure to store it in environment variables and  load it from there. This would also be helpful (no code changes) when the application runs in different environments. 
So, add the following environment variables 

**Windows:**
+ `set DB_URL = jdbc:postgresql://localhost:5432/db_name`
+ `set DB_PASSWORD = your_postgres_password`   
+ `set DB_USER = your_postgres_user` 

 **For dev environment (IntelliJ):**
 + Goto: `Run >> Edit Configurations >> MoviesApplication`
 + Under `Configuration` tab, click on `Environment Variables` and add these variables one by one.

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

## Bibliography

###### 1. Setup Spring boot project in Intellij

+ https://www.javadevjournal.com/spring-boot/spring-boot-application-intellij/

###### 2. DB schema source

+ https://www.w3resource.com/sql-exercises/movie-database-exercise/joins-exercises-on-movie-database.php  

###### 3. Flyway

+ https://www.callicoder.com/spring-boot-flyway-database-migration-example/
+ https://flywaydb.org/documentation/migrations#naming  

###### 4. Load DB properties from environment variables

+ https://stackoverflow.com/a/35535138

###### 5. JPA
OffsetDateTime for Timestamp without Timezone
+ https://thoughts-on-java.org/map-date-time-api-jpa-2-2/
+ https://blog.jooq.org/tag/timestamp-with-time-zone/