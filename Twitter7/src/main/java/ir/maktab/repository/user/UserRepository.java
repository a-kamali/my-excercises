package ir.maktab.repository.user;

import ir.maktab.domin.entity.User;

import java.sql.SQLException;

public interface UserRepository {

    User addUser(String username,String password) throws SQLException;
    User findUserBYID() throws SQLException;
    User findUserByUernameAndPassword(String username,String password) throws SQLException;

}
