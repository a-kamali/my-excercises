package ir.maktab.service.user;

import ir.maktab.domain.entities.Tweet;
import ir.maktab.domain.entities.User;
import ir.maktab.repository.user.UserRepositrory;
import ir.maktab.service.tweet.TweetService;

import java.sql.SQLException;

public class UserServiceImpl implements UserServic{
    private final UserRepositrory userRepositrory;
    private final TweetService tweetService;

    public UserServiceImpl(UserRepositrory userRepositrory, TweetService tweetService) {
        this.userRepositrory = userRepositrory;
        this.tweetService = tweetService;
    }

    @Override
    public User save(User user) throws SQLException {
        return userRepositrory.save(user);
    }

    @Override
    public Tweet createTweet(Tweet tweet) throws SQLException {
        return tweetService.save(tweet);
    }
// First Implementation
//    @Override
//    public Tweet updateTweet(Tweet tweet,String newContent) throws SQLException {
//        return tweetService.update(tweet,newContent);
//    }

        @Override
    public Tweet updateTweet(Integer id ,String newContent) throws SQLException {
        Tweet tweet = findTweetById(id);
        return tweetService.update(tweet,newContent);
    }



    @Override
    public Tweet findTweetById(Integer id) throws SQLException {
        return tweetService.findByID(id);
    }


}
