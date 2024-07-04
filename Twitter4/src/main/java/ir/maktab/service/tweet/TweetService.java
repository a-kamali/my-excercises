package ir.maktab.service.tweet;

import ir.maktab.domain.entities.Tweet;

import java.sql.SQLException;

public interface TweetService {
    Tweet save(Tweet tweet) throws SQLException;
   // Tweet update(Tweet tweet) throws SQLException;
    Tweet update(Tweet tweet,String newContent) throws SQLException;
    Tweet findByID(Integer id) throws SQLException;
}
