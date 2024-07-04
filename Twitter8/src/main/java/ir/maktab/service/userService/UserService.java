package ir.maktab.service.userService;

import ir.maktab.entity.User;

import java.sql.SQLException;

public interface UserService {

    public User signUp(String username, String password) throws SQLException;
    public boolean checkUsernameAndPassword(String username,String password) throws SQLException;
    public boolean isUsernameAvailable(String username) throws SQLException;
    public void Login(String username, String password) throws SQLException;

}
