package ir.maktab.repository.tweet;

import ir.maktab.domain.Entities.Tweet;

import java.sql.SQLException;

public interface TweetRepository {

    Tweet save(Tweet tweet) throws SQLException;
    Tweet update(String newContent, Integer tweetID) throws SQLException;
    void delete(Integer id) throws SQLException;
    Tweet findByID(Integer id) throws SQLException;
}






    //    Second Implementation - Insert FindById in Update Method
//    Tweet update(Tweet tweet,Integer tweetID) throws SQLException;
