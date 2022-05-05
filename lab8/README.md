# Laboratorul 8

 * [Compulsory](#Compulsory) :heavy_check_mark:
  * [Homework](#homework) :heavy_check_mark:
  * [Bonus](#bonus) ❌

## Enunt

Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

### Compulsory

* Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.). :heavy_check_mark:
* Write an SQL script that will create the following tables:
    - countries: id, name, code, continent :heavy_check_mark:
    - continents: id, name :heavy_check_mark:
* Update pom.xml, in order to add the database driver to the project libraries. :heavy_check_mark:
* Create a singleton class in order to manage a connection to the database. :heavy_check_mark:
* Create DAO classes that offer methods for creating countries and continents, and finding them by their ids and names; :heavy_check_mark:
* Implement a simple test using your classes. :heavy_check_mark:

![image](https://user-images.githubusercontent.com/79217056/166845442-9c38b7f2-5662-4dd8-b447-fffa3e780020.png)

## Homework

* Create the necessary table in order to store cities in your database. A city may contain: id, country, name, capital(0/1), latitude, longitude :heavy_check_mark:
* Create an object-oriented model of the data managed by the application. :heavy_check_mark:
* Create a tool to import data from a real dataset: World capitals gps or other. :heavy_check_mark:
* Display the distances between various cities in the world. :heavy_check_mark:
* (+1p) Create a 2D map (using Swing or JavaFX) and draw on it the cities at their corresponding locations. ❌

![image](https://user-images.githubusercontent.com/79217056/166929459-ed3763fb-f525-4ddf-83d2-9811c314afdd.png)


![image](https://user-images.githubusercontent.com/79217056/166929531-626b467c-21e2-4ff9-a178-88c69e4c5f0e.png)



