package ir.maktab.service.user;

import ir.maktab.domain.Entity.User;

import java.sql.SQLException;

public interface UserService {

    User signUp(String name, String password) throws SQLException;
    boolean login(String name, String password) throws SQLException;
}
