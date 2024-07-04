package ir.maktab.service.tweet;

import ir.maktab.domin.entity.Tweet;
import ir.maktab.domin.entity.User;

import java.sql.SQLException;

public interface TweetService {
    Tweet creatTweet(String content, User user) throws SQLException;
}
