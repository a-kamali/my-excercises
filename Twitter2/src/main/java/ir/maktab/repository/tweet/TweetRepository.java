package ir.maktab.repository.tweet;

import ir.maktab.domain.Entity.Tweet;
import ir.maktab.domain.Entity.User;

import java.sql.SQLException;

public interface TweetRepository {
    Tweet save(String content, User user) throws SQLException;
    Tweet update(Integer id, String newContent) throws SQLException;
    Tweet delete(String id) throws SQLException;
    Tweet findTweetByTweetId(String tweetId) throws SQLException;


    //        String updateQuery = "update tweet set content = ?, user_id = ? where id = ?";
    //        String deleteQuery = "delete from tweet where id = ?";
    //        String selectQuery = "select * from tweet where id = ?";
    //        String selectAllQuery = "select * from tweet";
    //        String findByIdQuery = "select * from tweet where id = ?";


}
