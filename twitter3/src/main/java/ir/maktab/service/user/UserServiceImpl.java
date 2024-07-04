package ir.maktab.service.user;

import ir.maktab.domain.Entities.Tweet;
import ir.maktab.domain.Entities.User;
import ir.maktab.repository.user.UserRepository;
import ir.maktab.service.tweet.TweetService;
import ir.maktab.util.AuthHolder;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TweetService tweetService;


    public UserServiceImpl(UserRepository userRepository, TweetService tweetService) {
        this.userRepository = userRepository;
        this.tweetService = tweetService;
    }


    // Third Implementation
    @Override
    public Tweet updateTweet(String newContent, Integer tweetID) throws SQLException {
        return tweetService.update(newContent,tweetID);
    }

    @Override
    public Tweet createTweet(Tweet tweet) throws SQLException {
        return tweetService.save(tweet);
    }

    @Override
    public boolean deleteTweetByID(Integer id) throws SQLException {
        if(tweetService.findByID(id) != null) {
           tweetService.deleteTweetBYID(id);
           return true;
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) throws SQLException {
        User user = userRepository.findByUsernameAndPassword(username,password);
        if(user != null){
            AuthHolder.tokenId = user.getId();
            AuthHolder.tokenName = user.getUsername();
            return true;
        }
        return false;
    }

    @Override
    public boolean signUp(String username, String password) throws SQLException {
        if(!userRepository.existByUsername(username)){
            userRepository.save(username,password);
            return false;
        }
        return true;

    }

    @Override
    public Tweet findTweetByID(Integer id) throws SQLException {
        return null;
    }
}
//    @Override
//    public Tweet findTweetByID(Integer id) throws SQLException {
//        return tweetService.findByID(id);
//    }

// First Implementation
//    @Override
//    public Tweet updateTweet(Tweet tweet,String newContent) throws SQLException {
//        tweet.setContent(newContent);
//        return tweetService.update(tweet);
//    }


//    // Second Implementation
//    @Override
//    public Tweet updateTweet(String newContent, Integer tweetID) throws SQLException {
//        Tweet tweet = new Tweet(newContent);
//        // tweet.setId(tweetID); It is false because This TweetID not exist
//        //return tweetService.update(tweet,tweetID);
//    }
//    @Override
//    public User save(User user) throws SQLException {
//        return userRepository.save(user);
//    }
