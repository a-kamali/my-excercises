package ir.maktab.service.user;

import ir.maktab.domain.Entity.Tweet;
import ir.maktab.domain.Entity.User;
import ir.maktab.repository.tweet.TweetRepository;
import ir.maktab.repository.user.UserRepository;
import ir.maktab.service.tweet.TweetService;
import ir.maktab.util.AuthHolder;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private  TweetService tweetService;
    private AuthHolder authHolder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String username, String password) throws SQLException {
        return userRepository.save(username, password);
    }
    public boolean login(String username, String password) throws SQLException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                authHolder.AuthId = user.getId();
                return true;
            }
        }
        return false;
    }

    public Tweet creatTweet(String content) throws SQLException {
        return tweetService.save(content,authHolder.AuthId);
    }


}
