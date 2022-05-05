# Laboratorul 8

 * [Compulsory](#Compulsory) :heavy_check_mark:
  * [Homework](#homework) 
  * [Bonus](#bonus) 

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
