package compulsory;

import java.sql.*;
import java.util.Random;

public class CountryDAO {

    /**
     * This method adds a new column to the countries table (id and code are distinct)
     *
     * @param name
     * @param idContinet
     * @throws SQLException
     */

    public void create(String name, int idContinet) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into countries values ( " + getIdCountry() + ", '" + name + "'," + getCodeCountry() + ", '" + getContinet(idContinet) + "')")) {
            pstmt.executeUpdate();
        }
    }

    /**
     * Returns a unique id
     *
     * @return
     * @throws SQLException
     */

    private int getIdCountry() throws SQLException {
        Random rand = new Random();
        int idRand = 0;
        boolean foundId = false;
        while (!foundId) {
            idRand = rand.nextInt(1000, 9999);
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select * from countries where  id = " + idRand)) {
                foundId = !rs.next();
            }
        }
        return idRand;
    }

    /**
     * Returns a unique code
     *
     * @return
     * @throws SQLException
     */

    private int getCodeCountry() throws SQLException {
        Random rand = new Random();
        int codeRand = 0;
        boolean foundCode = false;
        while (!foundCode) {
            codeRand = rand.nextInt(1000, 9999);
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select * from countries where  code=" + codeRand)) {
                foundCode = !rs.next();
            }

        }
        return codeRand;
    }

    /**
     * Returns continent with this id (findById method in ContinentDAO class)
     *
     * @param idContinet
     * @return
     * @throws SQLException
     */

    private String getContinet(int idContinet) throws SQLException {
        String result;
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continents where id = '" + idContinet + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

}
