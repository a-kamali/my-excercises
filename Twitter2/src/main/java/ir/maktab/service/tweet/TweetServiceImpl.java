package ir.maktab.service.tweet;

import ir.maktab.domain.Entity.Tweet;
import ir.maktab.domain.Entity.User;
import ir.maktab.repository.tweet.TweetRepository;

import java.sql.SQLException;

public class TweetServiceImpl implements TweetService {
    private TweetRepository tweetRepository;
    @Override
    public Tweet save(String content, Integer userID) throws SQLException {
        return tweetRepository.save(content, userID);
    }

    @Override
    public Tweet update(Integer id, String newContent) throws SQLException {
        return null;
    }

    @Override
    public Tweet delete(String id) throws SQLException {
        return null;
    }

    @Override
    public Tweet findTweetByTweetId(String tweetId) throws SQLException {
        return null;
    }
}
