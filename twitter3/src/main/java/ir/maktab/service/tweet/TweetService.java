package ir.maktab.service.tweet;

import ir.maktab.domain.Entities.Tweet;

import java.sql.SQLException;

public interface TweetService {

    Tweet save(Tweet tweet) throws SQLException;
    Tweet update(String newContent, Integer tweetID) throws SQLException;
    void  deleteTweetBYID(Integer id) throws SQLException;
    Tweet findByID(Integer id) throws SQLException;

}
//    Tweet update(Tweet tweet,Integer tweetId) throws SQLException;
