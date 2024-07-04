package ir.maktab.repository.tweet;

import ir.maktab.domain.Entities.Tweet;
import ir.maktab.domain.Entities.User;
import ir.maktab.util.AuthHolder;

import java.sql.*;

public class TweetRepositoryImpl implements TweetRepository {

    private final Connection connection;

    public TweetRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Tweet save(Tweet tweet) throws SQLException {
        String insertQuery = """
                insert into tweets(user_id,content,creat_time,creat_date)
                values(?,?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, tweet.getUser().getId());
        preparedStatement.setString(2, tweet.getContent());
        preparedStatement.setTime(3, Time.valueOf(tweet.getTime()));
        preparedStatement.setDate(4, Date.valueOf(tweet.getDate()));

        int affectRows = preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (affectRows > 0) {
            if (resultSet.next()) {
                tweet.setId(resultSet.getInt("id"));
            }
            preparedStatement.close();
        }
        return tweet;
    }


    //    Second Implementation - Insert FindById in Update Method
    @Override
    public Tweet update(String newContent, Integer tweetID) throws SQLException {
        Tweet returnedTweet = null;
        String selectQuery = """
                Select * from tweets as t 
                inner join users as u on t.user_id = u.id
                where t.id = ? AND t.user_id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(
                selectQuery,
                // IN Two next line  we want after selection, update Objects
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );

        preparedStatement.setInt(1, tweetID);
        preparedStatement.setInt(2, AuthHolder.tokenId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            resultSet.updateString("content",newContent);
            resultSet.updateRow();
            returnedTweet = new Tweet();
            returnedTweet.setId(resultSet.getInt("id"));
            returnedTweet.setUser(userMapper(resultSet));
            returnedTweet.setContent(newContent);
            returnedTweet.setTime(resultSet.getTime("creat_time").toLocalTime());
            returnedTweet.setDate(resultSet.getDate("creat_date").toLocalDate());
        }
        preparedStatement.close();

        return returnedTweet;
    }

    public User userMapper(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }


    public Tweet findByID(Integer id) throws SQLException {
        Tweet tweet = null;
        String selectQuery = """
                Select * from tweets
                where id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tweet = new Tweet();
            tweet.setId(resultSet.getInt("id"));
            tweet.setUserId(resultSet.getInt("user_id"));
            tweet.setContent(resultSet.getString("content"));
            tweet.setTime(resultSet.getTime("creat_time").toLocalTime());
            tweet.setDate(resultSet.getDate("creat_date").toLocalDate());
        }
        preparedStatement.close();
        return tweet;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String deletQuery = """
                DELETE FROM tweets WHERE id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(deletQuery);
        preparedStatement.setInt(1, id);
        preparedStatement.executeQuery();
        preparedStatement.close();
    }
}
//    First Implementation
//    @Override
//    public Tweet update(Tweet tweet) throws SQLException {
//        String updateQuery = """
//                UPDATE tweets
//                SET content = ?
//                WHERE id = ?;
//                """;
//        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
//
//        preparedStatement.setString(1,tweet.getContent());
//        preparedStatement.setInt(2,tweet.getId());
//
//        preparedStatement.executeUpdate();
//
//        return tweet;
//    }
