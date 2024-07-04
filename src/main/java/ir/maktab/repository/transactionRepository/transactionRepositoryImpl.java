package ir.maktab.repository.transactionRepository;

import ir.maktab.entity.Account;
import ir.maktab.entity.Transaction;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class transactionRepositoryImpl implements  transactionRepository{
    private Connection connection;
    @Override
    public Transaction create(Integer originAccount_id, Integer destinationAccount_id, Double amount) throws SQLException {
        Transaction transaction = new Transaction();
        String createQuery = """
                insert into transaction(originAccount_id,destinationAccount_id,amount,date,time)
                values(?,?,?,?,?)
                """;
                PreparedStatement preparedStatement = connection.prepareStatement(createQuery,
                        PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, originAccount_id);
                preparedStatement.setInt(2, destinationAccount_id);
                preparedStatement.setDouble(3, amount);
                preparedStatement.setDate(4, Date.valueOf(LocalDate.now()));
                preparedStatement.setTime(5, Time.valueOf(LocalTime.now()));
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    transaction.setId(resultSet.getInt("id"));
                    transaction.setId(resultSet.getInt("orginAccount_id"));
                    transaction.setId(resultSet.getInt("destinationAccount_id"));
                    transaction.setId(resultSet.getInt("amount"));
                    transaction.setDate(resultSet.getDate("date").toLocalDate());
                    transaction.setTime(resultSet.getTime("time").toLocalTime());
                }

        return transaction;
    }

    @Override
    public boolean update(Integer originAccount_id, Integer destinationAccount_id, Double amount) {
        String updateQuery = """
                Select 
                """;
        return false;
    }
}
