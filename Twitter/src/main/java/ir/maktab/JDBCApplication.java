package ir.maktab;

import ir.maktab.Util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCApplication {

    public static void main(String[] args)  throws SQLException {


        Connection connection = DriverManager.getConnection(
            ApplicationProperties.URL_DB,
                ApplicationProperties.USER,
                ApplicationProperties.PASS
        );

        connection.setAutoCommit(true);


    }
}
