package ir.maktab.repository.tweet;

import ir.maktab.domin.entity.Tweet;
import ir.maktab.domin.entity.User;
import ir.maktab.util.AuthHolder;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class TweetRepositoryImpl implements TweetRepository{
    private Connection connection;

    public TweetRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Tweet addTweet(String content, User user) throws SQLException {
        Tweet tweet = null;
        String insertQuery = """
                insert into tweets(user_id,content,creat_time,creat_date)
                values(?,?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,content);
        preparedStatement.setTime(3, Time.valueOf(LocalTime.now()));
        preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
           tweet.setId(resultSet.getInt("id"));
           tweet.setUser(AuthHolder.user);
           tweet.setContent(resultSet.getString("content"));
           tweet.setTime(resultSet.getTime("creat_time").toLocalTime());
           tweet.setDate(resultSet.getDate("creat_date").toLocalDate());
           return tweet;
        }
        return null;
    }

}
