package ir.maktab;

import ir.maktab.util.ApplicationProperties;

import java.sql.*;



public class JDBCApplication {
    public static void main(String[] args) throws SQLException {
    Connection connection = DriverManager.getConnection(
            ApplicationProperties.DB_URL,
            ApplicationProperties.DB_USER,
            ApplicationProperties.DB_PASSWORD
    );
    Statement statement = connection.createStatement();
    String query = "select * from customer;";
    ResultSet resultSet = statement.executeQuery(query);



//    connection.setAutoCommit(true);
//    connection.close();

    }
}
