package ir.maktab.service.tweet;

import ir.maktab.domain.Entities.Tweet;
import ir.maktab.repository.tweet.TweetRepository;

import java.sql.PreparedStatement;
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

    @Override
    public Tweet update(String newContent, Integer tweetID) throws SQLException {
        return tweetRepository.update(newContent,tweetID);
    }

    @Override
    public void deleteTweetBYID(Integer id) throws SQLException {
         tweetRepository.delete(id);
    }

    @Override
    public Tweet findByID(Integer id) throws SQLException {
        return tweetRepository.findByID(id);
    }

}

//    @Override
//    public Tweet update(Tweet tweet,Integer tweetId) throws SQLException {
//        return tweetRepository.update(tweet,tweetId);
//    }

