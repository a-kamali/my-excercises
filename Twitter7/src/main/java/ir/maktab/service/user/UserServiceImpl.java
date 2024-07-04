package ir.maktab.service.user;

import ir.maktab.domin.entity.User;
import ir.maktab.repository.user.UserRepository;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signup(String username, String password) throws SQLException {
        return userRepository.addUser(username,password);
    }

    @Override
    public User findUserBYID() throws SQLException {
        return userRepository.findUserBYID();
    }

    @Override
    public boolean findUserByUernameAndPassword(String username, String password) throws SQLException {
        return userRepository.findUserByUernameAndPassword(username,password);
    }
}
