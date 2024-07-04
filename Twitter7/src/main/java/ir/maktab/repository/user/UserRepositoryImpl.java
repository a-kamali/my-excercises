package ir.maktab.repository.user;

import ir.maktab.domin.entity.User;
import ir.maktab.util.AuthHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User addUser(String username, String password) throws SQLException {
        User user = null;
        String addQuery = """
                insert into users(username,password) 
                values(?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(addQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    @Override
    public User findUserBYID() throws SQLException {
        User user = null;
        String findQuery = """
                Select * from users
                where id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, AuthHolder.userID);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            user.setId(AuthHolder.userID);
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }
        return user;
    }

    @Override
    public User findUserByUernameAndPassword(String username, String password) throws SQLException {
       User user = null;
        String findQuery = """
                Select * from users
                where username = ? And password = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
           user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }


        return user;
    }













}
