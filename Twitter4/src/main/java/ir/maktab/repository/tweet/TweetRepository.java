package ir.maktab.repository.tweet;

import ir.maktab.domain.entities.Tweet;

import java.sql.SQLException;

public interface TweetRepository {

    Tweet save(Tweet tweet) throws SQLException;
    // Tweet update(Tweet tweet) throws SQLException;
     Tweet update(Tweet tweet,String newContent) throws SQLException;

    Tweet findByID(Integer id) throws SQLException;
}
