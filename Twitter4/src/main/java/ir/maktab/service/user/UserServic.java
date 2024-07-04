package ir.maktab.service.user;

import ir.maktab.domain.entities.Tweet;
import ir.maktab.domain.entities.User;

import java.sql.SQLException;

public interface UserServic {

    User save(User user) throws SQLException;
    Tweet createTweet(Tweet tweet) throws SQLException;
    Tweet updateTweet(Integer id ,String newContent) throws SQLException;
    //Tweet updateTweet(Tweet tweet,String newContent) throws SQLException;
    Tweet findTweetById(Integer id) throws SQLException;


}
