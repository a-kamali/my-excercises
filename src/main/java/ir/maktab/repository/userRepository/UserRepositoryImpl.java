package ir.maktab.repository.userRepository;

import ir.maktab.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository {
    private final Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User create(String username, String password) throws SQLException {
        User user = new User();
        String addQuery = """
                insert into users(username,password) values(?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(addQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }
        connection.close();
        preparedStatement.close();
        return user;
    }

    @Override
    public User find(String username) throws SQLException {
        User user = new User();
        String findQuery = """
                Select * from users
                where username = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }
        connection.close();
        preparedStatement.close();
        return user;
    }
}
