package ir.maktab.repository.tweet;

import ir.maktab.domin.entity.Tweet;
import ir.maktab.domin.entity.User;

import java.sql.SQLException;

public interface TweetRepository {

    Tweet addTweet(String content, User user) throws SQLException;
}
