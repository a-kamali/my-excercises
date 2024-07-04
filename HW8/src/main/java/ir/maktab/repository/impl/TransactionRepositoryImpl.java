package ir.maktab.repository.impl;

import ir.maktab.entity.Transaction;
import ir.maktab.repository.TransactionRepository;
import java.sql.*;


public class TransactionRepositoryImpl implements TransactionRepository {
    private final Connection connection;

    public TransactionRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void save(Transaction transaction) throws SQLException {
        String query = "INSERT INTO transactions (type, amount, date, user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, transaction.getType());
        statement.setDouble(2, transaction.getAmount());
        statement.setDate(3, new Date(transaction.getDate().getTime()));
        statement.setInt(4, transaction.getUserId());
        statement.executeUpdate();
    }



    @Override
    public Transaction[] findByType(String type) throws SQLException {
        String query = "SELECT * FROM transactions WHERE type = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, type);
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        Transaction[] transactions = new Transaction[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            Transaction transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getString("type"),
                    resultSet.getDouble("amount"),
                    resultSet.getDate("date"),
                    resultSet.getInt("user_id")
            );
            transactions[index] = transaction;
            index++;
        }

        return transactions;
    }





    @Override
    public Transaction[] findByDateRange(String startDate, String endDate) throws SQLException {
        String query = "SELECT * FROM transactions WHERE date BETWEEN ? AND ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, Date.valueOf(startDate));
        statement.setDate(2, Date.valueOf(endDate));
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        Transaction[] transactions = new Transaction[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            Transaction transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getString("type"),
                    resultSet.getDouble("amount"),
                    resultSet.getDate("date"),
                    resultSet.getInt("user_id")
            );
            transactions[index] = transaction;
            index++;
        }

        return transactions;
    }


    @Override
    public Transaction[] findByAmountGreaterThan(double amount) throws SQLException {
        String query = "SELECT * FROM transactions WHERE amount > ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDouble(1, amount);
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        Transaction[] transactions = new Transaction[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            Transaction transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getString("type"),
                    resultSet.getDouble("amount"),
                    resultSet.getDate("date"),
                    resultSet.getInt("user_id")
            );
            transactions[index] = transaction;
            index++;
        }

        return transactions;
    }

    public Transaction[] findAllByUser(int userId) throws SQLException {
        String query = "SELECT * FROM transactions WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        Transaction[] transactions = new Transaction[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            Transaction transaction = new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getString("type"),
                    resultSet.getDouble("amount"),
                    resultSet.getDate("date"),
                    resultSet.getInt("user_id")
            );
            transactions[index] = transaction;
            index++;
        }

        return transactions;
    }

}
