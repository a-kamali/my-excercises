package ir.maktab.service.tweet;

import ir.maktab.domain.Entity.Tweet;
import java.sql.SQLException;

public interface TweetService {
    Tweet save(String content, Integer userID) throws SQLException;
    Tweet update(Integer id, String newContent) throws SQLException;
    Tweet delete(String id) throws SQLException;
    Tweet findTweetByTweetId(String tweetId) throws SQLException;


}
