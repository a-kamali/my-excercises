package ir.maktab.repository.user;

import ir.maktab.config.DataSource;
import ir.maktab.domain.Entity.User;

import java.sql.*;

public class UserRepositoryImpl implements UserRepository{
    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public User save(String username, String password) throws SQLException {
        String sql = "insert into users (username, password) values (?, ?)";
        PreparedStatement preparedStatement =  connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            User user = new User();
            user.setId(generatedKeys.getInt(1));
            user.setName(username);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        String findQuery = "select * from users where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setName(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            return user;
        }
        return null;
    }


}
