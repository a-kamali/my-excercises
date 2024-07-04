package ir.maktab.repository.userRepository;

import java.sql.SQLException;
import ir.maktab.entity.User;

public interface UserRepository {

     User find(String username) throws SQLException;
     User create(String username,String password) throws SQLException;

}
