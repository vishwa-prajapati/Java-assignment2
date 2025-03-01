package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/product_catalogue";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Vishwa@2005";

    static {
        try {
            Class.forName("org.postgresql.Driver"); // Load PostgreSQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
