package ir.maktab.service.userService;

import ir.maktab.entity.User;
import ir.maktab.repository.userRepository.UserRepository;
import ir.maktab.util.AuthHolder;

import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    public AuthHolder authHolder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authHolder = new AuthHolder();
    }

    @Override
    public User signUp(String username, String password) throws SQLException {
        return userRepository.create(username,password);
    }
    public void Login(String username, String password) throws SQLException {
        User user = userRepository.read(username,password);
        authHolder.(user.getId());
        authHolder.setTokenName(user.getUsername());
    }

    @Override
    public boolean checkUsernameAndPassword(String username, String password) throws SQLException {
        User user = userRepository.read(username,password);
        return user != null;
    }

    @Override
    public boolean isUsernameAvailable(String username) throws SQLException {
        User user = userRepository.read(username);
        if(user == null){
            System.out.println("This Username is not available");
            return false;
        }
        return true;
    }
}
