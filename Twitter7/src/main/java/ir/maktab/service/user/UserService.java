package ir.maktab.service.user;

import ir.maktab.domin.entity.User;

import java.sql.SQLException;

public interface UserService {
    User signup(String username, String password) throws SQLException;
    User findUserBYID() throws SQLException;
    boolean findUserByUernameAndPassword(String username, String password) throws SQLException;

}
