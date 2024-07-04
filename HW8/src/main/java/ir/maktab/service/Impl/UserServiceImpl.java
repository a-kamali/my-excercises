package ir.maktab.service.Impl;

import ir.maktab.entity.User;
import ir.maktab.repository.UserRepository;
import ir.maktab.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) throws SQLException {
        userRepository.save(user);
    }

    @Override
    public User login(String username, String password) throws SQLException {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    @Override
    public boolean signUp(String username, String password) throws SQLException {
        if (!userRepository.existsByUsername(username)) {
            userRepository.save(new User(username, password));
            return true;
        }
        return false;
    }
}
