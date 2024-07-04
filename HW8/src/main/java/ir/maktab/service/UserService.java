package ir.maktab.service;

import ir.maktab.entity.User;

import java.sql.SQLException;

public interface UserService {
    void register(User user) throws SQLException;
    User login(String username, String password) throws SQLException;
    boolean signUp(String username, String password) throws SQLException;
}
