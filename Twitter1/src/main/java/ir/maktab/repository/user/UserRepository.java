package ir.maktab.repository.user;

import ir.maktab.domin.User;

import java.sql.SQLException;

public interface UserRepository {
    User save(User user) throws SQLException;

}
