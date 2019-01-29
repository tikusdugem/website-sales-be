# GOALS!

Another platform version of [desktop-sales](https://github.com/tikusdugem/desktop-sales)

# WHAT I AM USING ?!

- Spring Boot 2.1.0, generate template from [Spring Initializr](https://start.spring.io/).
- Apache Maven 3.6.0
- JDK 1.8
- Visual Studio Code 1.28.2
- MySQL Community Server 8.0.13
- Spring Security with JWT (Soon)
- Hash password (Soon)


# HOW TO PLAY ?!

## Database

- Make sure you already install MySQL and start the server
- Login *(Default)*
    ```
    mysql -p
    ```
- Create database
    ```
    create database websitesales;
    ```
- Grant all the privileges
    ```
    grant all on websitesales.* to "root"@"localhost";
    ```
- Set password
    ```
    alter user "root"@"localhost" identified by "root";
    ```

## Application

- Clone this repo
    ```
    git clone https://github.com/tikusdugem/website-sales-be.git
    ```
- Move to the directory
    ```
    cd website-sales-be
    ```
- For the first time you must change value of `spring.jpa.hibernate.ddl-auto` on `src/main/resources/application.properties` to `create` because we don't have the database structure yet. After the first run, You can stop the app and change the value to `update` again and then run again.

- Build project
    ```
    mvn clean package
    ```
- Run Project
    ```
    java -jar target/sales-backend-0.0.1-SNAPSHOT.jar
    ```
- *Optional:* Shorthand for build and run project
    ```
    mvn spring-boot:run
    ```
- Test the app! If this works should be get response `Saved!`
    ```
    curl "localhost:2000/user/add?name=test&username=the&password=app"
    ```