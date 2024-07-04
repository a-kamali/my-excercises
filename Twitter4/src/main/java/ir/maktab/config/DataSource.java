package ir.maktab.config;

import ir.maktab.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(
                    ApplicationProperties.DB_URL,
                    ApplicationProperties.DB_USER,
                    ApplicationProperties.DB_Pass
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
