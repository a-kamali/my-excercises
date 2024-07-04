package ir.maktab.service.userService;

import ir.maktab.repository.userRepository.UserRepository;

import java.sql.SQLException;
import ir.maktab.entity.User;
import ir.maktab.util.AuthHolder;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isUsernameAvailable(String username) throws SQLException {
        User user =  userRepository.find(username);
        return user != null;
    }

    @Override
    public User createUser(String username, String password) throws SQLException {
        return userRepository.create(username,password);
    }

    @Override
    public boolean Login(String username, String password) throws SQLException {
        User user = userRepository.find(username);
        if(user.getPassword().equals(password)){
            AuthHolder.getInstance().setTokenId(user.getId());
            return true;
        }
        return false;
    }
}
