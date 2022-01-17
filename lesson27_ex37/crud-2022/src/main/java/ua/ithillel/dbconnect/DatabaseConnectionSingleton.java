package ua.ithillel.dbconnect;

import java.sql.*;

public class DatabaseConnectionSingleton {
    private static DatabaseConnectionSingleton instance;
    private Connection connection;

    public static synchronized DatabaseConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        if (connection == null) {
            String url = "jdbc:postgresql://localhost:5432/testdb";
            String user = "postgres";
            String password = "postgres";

            try {
                Connection con = DriverManager.getConnection(url, user, password);
                System.out.println("Connection got");
                connection = con;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
