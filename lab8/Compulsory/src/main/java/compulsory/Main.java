package compulsory;

import java.sql.SQLException;

/**
 * In the Main class I do the following:
 * create the connection to the database
 * I add 2 continents to the table of contents
 * I add 3 countries in the table of countries
 * I use the findByName method to find the id of the continent
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
            Database.getConnection().close();

        } catch (SQLException e) {
            System.err.println(e);
        }

    }

}

