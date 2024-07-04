package ir.maktab.repository.user;

import ir.maktab.domain.Entities.User;

import java.sql.SQLException;

public interface UserRepository {

    User save(String username,String password) throws SQLException;
    User findByUsernameAndPassword(String username,String password) throws SQLException;
    boolean existByUsername(String username) throws SQLException;
}
