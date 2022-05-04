package compulsory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * The DataBase class is a Singleton class. This class achieves:
 * Database connection
 * Disconnecting from the database
 * I used an Oracle database
 */

public class Database {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "student";
    private static final String PASSWORD = "student";
    private static Connection connection = null;

    private Database() {
    }

    public static Connection getConnection() {
        return connection;
    }

    static void createConnection() {
        try {
            DriverManager.registerDriver(
                    new oracle.jdbc.OracleDriver());

            // Reference to connection interface
            connection = DriverManager.getConnection(URL, USER,
                    PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }
}
