# JDBC / POOL / JPA

## JDBC

### ¿What is JDBC?

JDBC stands for Java Database Connectivity, which translates to "Database Connectivity in Java". It is an API (Application Programming Interface) that provides a set of classes and interfaces for accessing relational databases from a Java program.

---

### Data Base

To carry out the work I have created a very simple database called "Game" which is located in the `db` folder.

| **Name** |   **Year**  |
|:--------:|:-----------:|
|  Game 1  | Year Game 1 |

**Name**: Is a varchar
**Year**: Is a integer

---

### Driver

A JDBC driver is a software component that provides a set of classes and methods for establishing a connection between a Java application and a database. It acts as a bridge between the Java application and the database management system (DBMS). The driver communicates with the database server using a specific protocol and translates the requests from the Java application into the format that the database server can understand.

---

### Code

In the `src` folder we can find the code to insert and delete games from the Game database.

`ClearTerminal.java`: Cleans the terminal so that when we start the program there are no unwanted things on the screen.
`Sleep.java`: It gives us a timeout between messages in the terminal. I use it only so that when the games of the database are shown by screen it gives time to the user to see them.
`DataBase.java`: It provides connection with the database and has established the methods to insert, delete and show the games.
`Game.java`: Class where the characteristics of the Game objects to be created are defined.`
`Main.java`: File in which the main program is executed.

---

## JDBC POOL

