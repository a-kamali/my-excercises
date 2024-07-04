package ir.maktab.service.user;

import ir.maktab.domin.User;

import java.sql.SQLException;

public interface UserService {

    void save(User user) throws SQLException;
}
