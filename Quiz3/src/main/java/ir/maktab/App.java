package ir.maktab;

import java.sql.*;
import java.util.Scanner;

public class App
{
    static final String URL_DB ="jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main( String[] args )
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL_DB,USER,PASS);

            String query = "INSERT INTO table (fistname, lastname, username,password)\n" +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement pstm = connection.prepareStatement(query);
            Scanner input = new Scanner(System.in);

            String firstName = input.nextLine();
            String lastName = input.nextLine();
            String username = input.nextLine();
            String password = input.nextLine();
            ResultSet resultSet = pstm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("firstname: "+ resultSet.getString("firstname")
                +"lastname: "+ resultSet.getString("lastname")
                +"username: "+ resultSet.getString("username")
                +"password: "+ resultSet.getString("password")


                );
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

