package ir.maktab.config;

import ir.maktab.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(
                    ApplicationProperties.DataBase_URL,
                    ApplicationProperties.Database_User,
                    ApplicationProperties.Database_Pass
            );
        }catch (Exception e){
            System.out.println("Wrong Database Connection");
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
