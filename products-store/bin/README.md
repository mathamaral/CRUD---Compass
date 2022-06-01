# spring-boot-rest-api-h2-database
This is a very basic project for beginners to learn about **Spring Boot CRUD** operations using **REST-API** and **H2 Embedded Database**. We all know about CRUD operation is the combination of Create (SAVE), Read (GET), Update (PUT) and Delete (DELETE). Some of us do not know about H2 Database but we all know about MySQL or PostgreSQL database. Let's learn about H2!<br/>

## H2 Database
H2 is an embedded and in-memory database. That means the data we are going to save using our spring boot project will be stored in a temporary memory. In this project we will save Student entity (id, name, age, email) in our H2 db. When we will store the Student object, It persists only in system-memory for that session not in the disk for permanently. That means if the session end, the data from the H2 DB will be erased. What about if we want to store data permanently in disk? Well, for this purpose, we use MySQL, PostgreSQL or OracleDB. <br/>

There are some other benifits too. We do not need to install H2 DB in our system, just need to add dependency to the spring boot pom.xml and configurations in application.properties. For this benifits, H2 DB is used widely for POCs (Proof of Concepts) and unit testing. Apache Derby is another known in-memory database.<br/> 

The best way is to create a **Spring Boot** project using **Spring Stater Project** to add **Spring Web**, **Spring Data JPA** and **H2 Database** dependencies. A similar link can be followed if you are interested how to add STS in Eclipse IDE and add dependency using Spring Starter Project [GitHub](https://github.com/rafsan-jany/spring-boot-web). <br/>

The **Spring Web**, **Spring Data JPA** and **H2 Database** dependencies in **pom.xml** are <br/>

``````
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
``````

The configuration in **appliction.properties** is <br/>

``````````
#enabling the H2 console  
spring.h2.console.enabled=true

spring.datasource.url=jdbc:h2:mem:rjanytest
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=123

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
``````````
Here `spring.datasource.url=jdbc:h2:mem:rjanytest` **rjanytest** is the database name.

## Dive into the project
Download or clone this project, import this to your favourite IDE and run. This project will run on default spring boot port on **localhost** is **8080**. I have implemented 5 end points for serving the purpose of CRUD operations. The end points are : <br/>

HTTP Operation | End Points | Purpose
------------ | ------------- | --------------
POST | http://localhost:8080/student | Save student
GET | http://localhost:8080/student/1 | Fetch student using ID
GET | http://localhost:8080/student | Fetch all students
PUT | http://localhost:8080/student/1 | Update student using ID
DELETE | http://localhost:8080/student/1 | Delete student using ID

After starting the project on port 8080, first need to login the H2 Database using the `http://localhost:8080/h2-console/` url. just insert the password that is set in application.properties. <br/>

![h2_db_login](https://user-images.githubusercontent.com/27615818/124883761-7bae4e80-dff3-11eb-883a-c1968fee2f11.PNG)

There is a table created name **Student** in our **rjanyTest** database. Let's insert a student in the Student table using **postman**.

![Post](https://user-images.githubusercontent.com/27615818/124884378-0727df80-dff4-11eb-830e-ac03a593a573.PNG)

Let's check the table using the browser. Click on the Student table and then click Run. The Student entity is saved in the table with id 1. wow!

![h2](https://user-images.githubusercontent.com/27615818/124884784-6ede2a80-dff4-11eb-8f93-4f7be2655f87.PNG)

Let's try with **GET**, **GET** for all, **PUT** and **DELETE** and check the H2 database using browser.

**GET**
![Get](https://user-images.githubusercontent.com/27615818/124885502-25daa600-dff5-11eb-9478-41801c1ce795.PNG)

**GET all** <br/>
Before this we need to save another Student entity. 
![GetAll](https://user-images.githubusercontent.com/27615818/124885681-54588100-dff5-11eb-8259-bafa9aa2c8b0.PNG)

**PUT**
![Put Student](https://user-images.githubusercontent.com/27615818/124885904-9255a500-dff5-11eb-854b-1d36e28c4e31.PNG)

**DELETE**
![delete](https://user-images.githubusercontent.com/27615818/124886338-f2e4e200-dff5-11eb-87db-6ffd979fb00d.PNG)

That's it for today. Learned a lot!




