package ir.maktab.repository.impl;


import ir.maktab.entity.User;
import ir.maktab.repository.UserRepository;
import java.sql.*;



public class UserRepositoryImpl implements UserRepository {
    private Connection connection;
    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public UserRepositoryImpl() {

    }


    @Override
    public void save(User user) throws SQLException {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }



    @Override
    public User findByUsername(String username) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
        statement.setString(1, username);
        resultSet = statement.executeQuery();

        user = new User();
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));


        return user;
    }


}
