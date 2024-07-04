package ir.maktab.repository.user;

import ir.maktab.domain.Entities.Tweet;
import ir.maktab.domain.Entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository{
    private final Connection connection;

    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(String username, String password) throws SQLException {
        User user = null;
        String insertQuery = """
                insert into users(username,password) value(?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2,password);

        int affectedRows = preparedStatement.executeUpdate();
        ResultSet resultSet =  preparedStatement.getGeneratedKeys();

        if(affectedRows > 0){
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(username);
                user.setPassword(password);
            }
            preparedStatement.close();
        }
        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;
        String selectQuery = """
                select * from users 
                where (username = ? And password = ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery
                ,PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(username);
            user.setPassword(password);
        return user;
        }
        preparedStatement.close();
        return null;
    }

    @Override
    public boolean existByUsername(String username) throws SQLException {
        String selectQuery = """
                select count(id) from users 
                where username = ?         
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
       return resultSet.next() && resultSet.getInt(1) > 0;
    }
}
