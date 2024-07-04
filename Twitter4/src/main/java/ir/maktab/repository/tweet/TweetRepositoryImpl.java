package ir.maktab.repository.tweet;

import ir.maktab.domain.entities.Tweet;

import java.sql.*;

public class TweetRepositoryImpl implements TweetRepository {
    private final Connection connection;

    public TweetRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Tweet save(Tweet tweet) throws SQLException {
        String insertQuery = """
                insert into tweets(user_id,content,creat_time,creat_date) values (?,?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(
                insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, tweet.getUserID());
        preparedStatement.setString(2, String.valueOf(tweet.getContent()));
        preparedStatement.setTime(3, Time.valueOf(tweet.getCreateTime()));
        preparedStatement.setDate(4, Date.valueOf(tweet.getCreateDate()));

        int affectedRows = preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (affectedRows > 0) {
            if (resultSet.next()) {
                tweet.setId(resultSet.getInt("id"));
            }
        }
        preparedStatement.close();
        return tweet;
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
//        preparedStatement.setInt(1, tweet.getContent());
//        preparedStatement.setString(2, tweet.getId());
//
//        preparedStatement.executeUpdate();
//        return tweet;
//
//    }


    // Second Implementation
    @Override
    public Tweet update(Tweet tweet, String newContent) throws SQLException {
        String updateQuery = """
                UPDATE tweets
                SET content = ?
                WHERE id = ?;
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

        preparedStatement.setString(1,newContent);
        preparedStatement.setInt(2,tweet.getId());

        preparedStatement.executeUpdate();
        return tweet;
    }



    @Override
    public Tweet findByID(Integer id) throws SQLException {
        Tweet tweet1 = null;
        String selectQuery = """
                Select * from tweets where id = ?;
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            tweet1 = new Tweet();
            tweet1.setId(id);
            tweet1.setUserID(resultSet.getInt("user_id"));
            tweet1.setContent(resultSet.getString("content"));
            tweet1.setCreateTime(resultSet.getTime("creat_time").toLocalTime());
            tweet1.setCreateDate(resultSet.getDate("creat_date").toLocalDate());
        }
        return tweet1;
    }


}
