package ir.maktab.service.user;

import ir.maktab.domin.User;
import ir.maktab.repository.user.UserRepository;

import java.sql.SQLException;


public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) throws SQLException {
        userRepository.save(user);
    }
}
