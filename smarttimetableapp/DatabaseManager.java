package smarttimetableapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Relative path to the file created in IntelliJ:
    private static final String URL = "jdbc:sqlite:timetable.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}