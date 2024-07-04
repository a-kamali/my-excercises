package ir.maktab.service.tweet;

import ir.maktab.domin.entity.Tweet;
import ir.maktab.domin.entity.User;
import ir.maktab.repository.tweet.TweetRepository;

import java.sql.SQLException;

public class TweetServiceImpl implements TweetService{
    private TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet creatTweet(String content, User user) throws SQLException {
        return tweetRepository.addTweet(content,user);
    }
}
