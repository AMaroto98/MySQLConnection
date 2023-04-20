# JDBC / JDBC POOL / JPA

## Index

- [JDBC](#jdbc)
    - [What is JDBC?](#what-is-jdbc)
    - [Data Base](#data-base)
    - [Driver](#driver)
    - [Code](#code)

- [JDBC Pool](#jdbc-pool)
    - [What is JDBC Pool?](#what-is-jdbc-pool)
    - [Maven](#maven)
    - [Pom.xml](#pomxml)
    - [Code](#code-1)

- [JPA](#jpa)
    - [What is JPA?](#what-is-jpa)
    - [Maven](#maven-1)
    - [Pom.xml](#pomxml-1)
    - [Persistence.xml](#persistencexml)
    - [Code](#code-2)

---

## JDBC

### What is JDBC?

JDBC stands for Java Database Connectivity, which translates to "Database Connectivity in Java". It is an API (Application Programming Interface) that provides a set of classes and interfaces for accessing relational databases from a Java program.

---

### Data Base

To carry out the work I have created a very simple database called "Game" which is located in the `db` folder.

| **Name** |   **Year**  |
|:--------:|:-----------:|
|  Game 1  | Year Game 1 |

- **Name**: Is a varchar
- **Year**: Is a integer

---

### Driver

A JDBC driver is a software component that provides a set of classes and methods for establishing a connection between a Java application and a database. It acts as a bridge between the Java application and the database management system (DBMS). The driver communicates with the database server using a specific protocol and translates the requests from the Java application into the format that the database server can understand.

The driver is located in the `driver` folder and must be added to the project, depending on the IDE used, it will be done in one way or another.

---

### Code

In the `src` folder we can find the code to insert and delete games from the Game database.

- `ClearTerminal.java`: Cleans the terminal so that when we start the program there are no unwanted things on the screen.
- `Sleep.java`: It gives us a timeout between messages in the terminal. I use it only so that when the games of the database are shown by screen it gives time to the user to see them.
- `DataBase.java`: It provides connection with the database and has established the methods to insert, delete and show the games.
- `Game.java`: Class where the characteristics of the Game objects to be created are defined.
- `Main.java`: File in which the main program is executed.

---

## JDBC POOL

### What is JDBC Pool?

JDBC Pool is a technique used in Java applications to improve the performance of connecting to a database via JDBC.

Basically, instead of opening and closing a connection to the database each time an operation needs to be performed, several connections to the database are created and maintained in a "pool" of connections. In this way, when an operation needs to access the database, an available connection is taken from the pool, the operation is performed, and then the connection is returned to the pool so that it can be reused in a future operation.

There are several open source libraries available that provide JDBC Pool implementations for use in Java applications, such as Apache Commons DBCP and HikariCP.

We will use HikariCP.

---

### Maven

To perform this part of the project, it is necessary to use **Maven**. If you do not have Maven yet, you need to install it.

To check if it is already installed, you can run the following command:

~~~
mvn --version
~~~

If the version is displayed then it is already installed, if we get any error then it is not yet installed and it is necessary to proceed with its installation.

It can be installed by executing the following command:

~~~
sudo apt install maven
~~~

---

### Pom.xml

In Maven, a `pom.xml` file is the Project Object Model. It is an XML file that contains information about the project and the Maven configuration for the project.

The pom.xml file describes how the project is built, including information about dependencies, plugins and the project structure. It may also contain information such as the project name, version, author, description, project URL and other relevant information.

In the pom.xml file we will insert the following dependencies so that the project can be executed:

MySQL driver:
~~~
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.32</version>
</dependency>
~~~

HikariCP:
~~~
<dependency>
    <groupId>com.zaxxer</groupId>
    <artifactId>HikariCP</artifactId>
    <version>5.0.1</version>  
</dependency>
~~~

SLF4J:
~~~
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.8.0-beta4</version>
</dependency>
~~~

---

### Code

In the `src` folder we can find the code to insert and delete games from the Game database.

- `ClearTerminal.java`: Cleans the terminal so that when we start the program there are no unwanted things on the screen.
- `Sleep.java`: It gives us a timeout between messages in the terminal. I use it only so that when the games of the database are shown by screen it gives time to the user to see them.
- `DataBase.java`: It provides connection with the database and has established the methods to insert, delete and show the games.
- `Game.java`: Class where the characteristics of the Game objects to be created are defined.
- `Main.java`: File in which the main program is executed.

It differs from the previous form only in the `DataBase.java` file, since the way in which the connection is made is different.

---

## JPA

### What is JPA?

JPA provides a way to interact with a database from a Java application in an object-oriented manner, using Java classes and objects instead of SQL statements. JPA integrates with the Java programming language and provides an abstraction layer between the application code and the underlying database, allowing for greater portability and flexibility.

---

### Maven

To perform this part of the project, it is necessary to use **Maven**. If you do not have Maven yet, you need to install it.

To check if it is already installed, you can run the following command:

~~~
mvn --version
~~~

If the version is displayed then it is already installed, if we get any error then it is not yet installed and it is necessary to proceed with its installation.

It can be installed by executing the following command:

~~~
sudo apt install maven
~~~

---

### Pom.xml

In the pom.xml file we will insert the following dependencies so that the project can be executed:

MySQL driver:
~~~
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.32</version>
</dependency>
~~~

Persistence:
~~~
</dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.0.0</version>
</dependency>
~~~

Hibernate:
~~~
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core-jakarta</artifactId>
    <version>5.6.4.Final</version>
</dependency>
~~~

JAXB:
~~~
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>3.0.0</version>
</dependency>
~~~

---

### Persistence.xml

A persistence.xml file is a configuration file used by JPA (Java Persistence API) to define how the persistence layer of a Java application should be configured.

This file is located in the META-INF directory of the application and contains information about the database connection, the JPA persistence provider used, entity classes and configuration properties.

In the persistence.xml file, several persistence units can be defined, each with its own set of configuration properties. Each persistence unit is usually associated with a specific database.

The persistence.xml file is also used to define the application entity classes to be persisted, which is achieved through the "class" tag in the persistence unit definition.

In general, the persistence.xml file is a key element in the configuration of a Java application that uses JPA for data persistence.

---

### Data Base

For this case I have used the same database as in the tutorial, the database is as follows:

| **pl_id** | **pl_name** | **pl_rating** |
|:---------:|:-----------:|:-------------:|
|     ID    |     Name    |      Rate     |

- **pl_id**: Is a integer
- **pl_name**: Is a string
- **pl_rating**: Is a integer

---

### Code

In the `src` folder we can find the code to insert and print programming languages from the jpa_demo database.

- `Application.java`: File where the main program is executed and database inserts are performed.
- `JPAService.java`: File in which the database connection mode is set.
- `ProgrammingLanguages.java`: File in which the attributes of a programming language object are set and at the same time the database table is structured.

---