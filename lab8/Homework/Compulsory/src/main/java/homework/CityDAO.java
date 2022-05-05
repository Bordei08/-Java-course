package homework;

import java.sql.*;
import java.util.Random;

public class CityDAO {

    /**
     *This method adds a new column to the cities table (id is distinct)
     * @param name
     * @param idCountry
     * @param isCapital
     * @param latitude
     * @param longitude
     * @throws SQLException
     */

    public void create(String name, int idCountry, int isCapital, double latitude, double longitude) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into cities values ( " + getIdCity() + ", '" + getNameCountry(idCountry) + "','" + name + "', " + isCapital+ ", "+ +latitude+ "," + longitude + ")")) {
            pstmt.executeUpdate();
        }
    }

    /**
     *  Returns a unique id
     * @return
     * @throws SQLException
     */

    private int getIdCity() throws SQLException {
        Random rand = new Random();
        int idRand = 0;
        boolean foundId = false;
        while (!foundId) {
            idRand = rand.nextInt(1000, 9999);
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select * from cities where  id = " + idRand)) {
                foundId = !rs.next();
            }
        }
        return idRand;
    }

    /**
     *  Returns country with this id
     * @param idContry
     * @return
     * @throws SQLException
     */

    private String getNameCountry(int idContry) throws SQLException {
        String result;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where id = '" + idContry + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    /**
     *This method takes information about a city from the cities table and returns a City object initialized with that information
     * @param name
     * @return
     * @throws SQLException
     */

    public City getCity(String name) throws SQLException{
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select * from cities where name = '" + name + "'")) {
            rs.next();
            return new City(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4) , rs.getDouble(5), rs.getDouble(6) );
        }
    }

}
