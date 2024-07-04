package ir.maktab.repository.user;


import ir.maktab.domain.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepositrory{

    private final Connection connection;


    public UserRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User save(User user) throws SQLException {
        String insertQuery =  """
                insert into users(username,password) values (?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(
                insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        int affectedRows =preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if(affectedRows > 0){
            if(generatedKeys.next()){
                user.setId(generatedKeys.getInt("id"));
            }
        }
        preparedStatement.close();
        return user;
    }
}
