package ir.maktab.repository.user;

import ir.maktab.domain.Entity.User;

import java.sql.SQLException;

public interface UserRepository {

    User save(String username, String password) throws SQLException;
    User findByUsername(String username) throws SQLException;
}
