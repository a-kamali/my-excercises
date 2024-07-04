package ir.maktab.config;

import ir.maktab.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private Connection connection;

    public Connection getConnection(){
        try {
            return connection = DriverManager.getConnection(
                    ApplicationProperties.DB_URL,
                    ApplicationProperties.DB_Uername,
                    ApplicationProperties.DB_Password
            );
        } catch (SQLException e) {
            System.out.println("Entered Long DataBase Properties");;
            return null;
        }
    }
}
