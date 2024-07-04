package ir.maktab.repository;

import ir.maktab.entity.User;

import java.sql.SQLException;

public interface UserRepository {

    void save(User user) throws SQLException;
    User findByUsername(String username) throws SQLException;



}
