package homework;

import java.sql.SQLException;

/**
 * In the Main class I do the following:
 * create the connection to the database
 * I add 2 continents to the table of contents
 * I use the findByName method to find the id of the continent
 * I add 3 countries in the table of countries
 * I add 4 cities in the table of cities
 * We created the cities with the information in the database
 * I calculated the distance between cities using a Compute object
 * The script for the database is :
 */

/*

create table CONTINENTS
(
    ID   NUMBER        not null,
    NAME NVARCHAR2(20) not null
);

create table COUNTRIES
(
    ID        NUMBER        not null,
    NAME      NVARCHAR2(20) not null,
    CODE      NUMBER        not null,
    CONTINENT VARCHAR2(20)  not null
);

create table CITIES
(
    ID        NUMBER        not null,
    COUNTRY   NVARCHAR2(20) not null,
    NAME      NVARCHAR2(20) not null,
    CAPITAL   NUMBER(2)     not null,
    LATITUDE  FLOAT         not null,
    LONGITUDE FLOAT         not null
);

 */

public class Main {
    public static void main(String args[]) throws SQLException {
        try {

            Database.createConnection();
            var continents = new ContinentDAO();

            continents.create("Europe");
            continents.create("North America");
            Database.getConnection().commit();

            var countries = new CountryDAO();
            int europeId;
            int northAmericaId;

            northAmericaId = continents.findByName("North America");
            europeId = continents.findByName("Europe");

            countries.create("Romania", europeId);
            countries.create("Ukraine", europeId);
            countries.create("Mexico", northAmericaId);
            Database.getConnection().commit();

            var cities = new CityDAO();
            int idRomania;
            int idUkraine;
            int idMexico;

            idRomania = countries.findByName("Romania");
            idUkraine = countries.findByName("Ukraine");
            idMexico = countries.findByName("Mexico");


            cities.create("Kiev", idUkraine, 1, 50.45123,30.51432);
            cities.create("Bucharest", idRomania, 1, 44.4321,26.10321);
            cities.create("Yassi",idRomania,0,47.1317,27.57412);
            cities.create("Ciudad de México", idMexico, 1, 19.42412, -99.12421);

            City cityKiev = cities.getCity("Kiev");
            City cityYassi = cities.getCity("Yassi");
            City cityCiudadDiMexico = cities.getCity("Ciudad de México");
            City cityBucharest = cities.getCity("Bucharest");

            Database.getConnection().close();

            Compute compute = new Compute();

            System.out.println(compute.distanceBetween(cityKiev,cityYassi));
            System.out.println(compute.distanceBetween(cityYassi, cityCiudadDiMexico));
            System.out.println(compute.distanceBetween(cityKiev, cityBucharest));
            System.out.println(compute.distanceBetween(cityKiev,cityCiudadDiMexico));

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

}

