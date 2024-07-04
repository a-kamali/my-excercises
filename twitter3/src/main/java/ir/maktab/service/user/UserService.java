package ir.maktab.service.user;

import ir.maktab.domain.Entities.Tweet;
import ir.maktab.domain.Entities.User;

import java.sql.SQLException;

public interface UserService {

    Tweet updateTweet(String newContent,Integer tweetID) throws SQLException;
    Tweet createTweet(Tweet tweet) throws SQLException;
    boolean deleteTweetByID(Integer id) throws SQLException;
    boolean login(String username,String password) throws SQLException;
    boolean signUp(String username,String password) throws SQLException;
    Tweet findTweetByID(Integer id) throws SQLException;

}



    //Tweet updateTweet(Tweet tweet,String newContent) throws SQLException;
    //User save(User user) throws SQLException;
