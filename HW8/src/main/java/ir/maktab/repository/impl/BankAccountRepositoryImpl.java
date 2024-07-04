package ir.maktab.repository.impl;

import ir.maktab.entity.BankAccount;
import ir.maktab.repository.BankAccountRepository;
import java.sql.*;


public class BankAccountRepositoryImpl implements BankAccountRepository {
    private final Connection connection;

    public BankAccountRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public void save(BankAccount bankAccount) throws SQLException {
        String query = "INSERT INTO bank_accounts (account_number, balance, user_id) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, bankAccount.getAccountNumber());
        statement.setDouble(2, bankAccount.getBalance());
        statement.setInt(3, bankAccount.getUserId());
        statement.executeUpdate();
    }


    public BankAccount findByAccountNumber(String accountNumber) throws SQLException {
        String query = "SELECT * FROM bank_accounts WHERE account_number = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, accountNumber);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new BankAccount(
                    resultSet.getInt("id"),
                    resultSet.getString("account_number"),
                    resultSet.getDouble("balance"),
                    resultSet.getInt("user_id")
            );
        }
        return null;
    }






}
