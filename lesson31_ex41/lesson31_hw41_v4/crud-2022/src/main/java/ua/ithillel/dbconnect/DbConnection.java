package ua.ithillel.dbconnect;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    Connection getConnection() throws SQLException;
}
