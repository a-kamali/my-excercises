package ir.maktab.repository.userRepository;

import ir.maktab.entity.User;

import java.sql.SQLException;

public interface UserRepository {

    public User create(String username,String password) throws SQLException;
    public User read(String username,String password) throws SQLException;
    public User read(String username) throws SQLException;

    public User update();
    public void delete();

}
