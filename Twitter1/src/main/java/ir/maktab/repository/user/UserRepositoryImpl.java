package ir.maktab.repository.user;

import ir.maktab.domin.User;

import java.sql.*;


public class UserRepositoryImpl implements UserRepository {

    private Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(User user) throws SQLException {
        String insertQuery = """
                insert into users(username, password) values(?,?);
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());

        int affectedRows = preparedStatement.executeUpdate();

        if (affectedRows > 0) {
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        }
        return user;

    }
}
