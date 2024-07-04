package ir.maktab.service.userService;

import ir.maktab.entity.User;

import java.sql.SQLException;

public interface UserService {
    boolean isUsernameAvailable(String username) throws SQLException;
    User createUser(String username,String password) throws SQLException;
    boolean Login(String username,String password) throws SQLException;
}
