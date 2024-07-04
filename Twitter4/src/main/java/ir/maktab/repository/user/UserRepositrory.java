package ir.maktab.repository.user;

import ir.maktab.domain.entities.User;

import java.sql.SQLException;

public interface UserRepositrory {

    User save(User user) throws SQLException;
}
