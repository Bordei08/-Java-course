package compulsory;

import java.sql.*;
import java.util.Random;

public class ContinentDAO {

    /**
     * This method adds a new column to the continents table (id is distinct)
     *
     * @param name
     * @throws SQLException
     */

    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into continents  values (" + getIdContinet() + ", '" + name + "' )")) {
            pstmt.executeUpdate();
        }
    }

    public int findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name = '" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continents where id=" + id)) {
            return rs.next() ? rs.getString(1) : null;
        }
    }

    /**
     * Returns a unique id
     *
     * @return
     * @throws SQLException
     */

    private int getIdContinet() throws SQLException {
        Random rand = new Random();
        int idRand = 0;
        boolean foundId = false;
        while (!foundId) {
            idRand = rand.nextInt(1000, 9999);
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select * from continents where  id = " + idRand)) {
                foundId = !rs.next();
            }
        }
        return idRand;
    }

}
