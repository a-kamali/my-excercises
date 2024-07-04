package ir.maktab.repository.userRepository;

import ir.maktab.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository{
    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User create(String username, String password) throws SQLException {
        User user = new User();
        String createQuery = """
                insert into users(username,password) values(?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(createQuery
                ,PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
        }
        resultSet.close();
        preparedStatement.close();
        return user;
    }

    @Override
    public User read(String username,String password) throws SQLException {
        User user = new User();
        String findQuery = """
                Select * from users 
                where username = ? And
                      Password = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery
                ,PreparedStatement.RETURN_GENERATED_KEYS);
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
    public User read(String username) throws SQLException {
        User user = new User();
        String findQuery = """
                Select * from users 
                where username = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery
                ,PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,username);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }

        return user;
    }



    @Override
    public User update() {
        return null;
    }

    @Override
    public void delete() {

    }
}
