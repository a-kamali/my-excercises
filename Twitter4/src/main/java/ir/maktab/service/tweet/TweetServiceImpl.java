package ir.maktab.service.tweet;

import ir.maktab.domain.entities.Tweet;
import ir.maktab.repository.tweet.TweetRepository;

import java.sql.SQLException;

public class TweetServiceImpl implements TweetService{

    private final TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet save(Tweet tweet) throws SQLException {
        return tweetRepository.save(tweet);
    }

//    @Override
//    public Tweet update(Tweet tweet) throws SQLException {
//        return tweetRepository.update(tweet);
//    }

    @Override
    public Tweet update(Tweet tweet,String newContent) throws SQLException {
        return tweetRepository.update(tweet,newContent);
    }

    @Override
    public Tweet findByID(Integer id) throws SQLException {
        return tweetRepository.findByID(id);
    }
}
