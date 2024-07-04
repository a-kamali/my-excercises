package ir.maktab.repository.tweet;

import ir.maktab.domain.Entity.Tweet;
import ir.maktab.domain.Entity.User;

import java.sql.*;

public class TweetRepositoryImpl implements TweetRepository{
    private final Connection connection;

    public TweetRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Tweet save(String content, User user) throws SQLException {
        String insertQuery = "insert into tweet (content, user_id) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, content);
        preparedStatement.setLong(2, user.getId());
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        if (generatedKeys.next()) {
            Tweet tweet = new Tweet();
            tweet.setContent(content);
            tweet.setUser(user);
            return tweet;
        }
        return null;
    }

    @Override
    public Tweet update(Integer id, String newContent) throws SQLException {
        String updateQuery = "update tweet set content = ?, user_id = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, newContent);
        preparedStatement.setLong(2, id);
        preparedStatement.executeUpdate();
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
