package ir.maktab.service;

import ir.maktab.entity.Transaction;

import java.sql.SQLException;

public interface TransactionService {

    void recordTransaction(Transaction transaction) throws SQLException;
    Transaction[] getTransactionsByType(String type) throws SQLException;
    Transaction[] getTransactionsByDateRange(String startDate, String endDate) throws SQLException;
    Transaction[] getTransactionsByAmountGreaterThan(double amount) throws SQLException;
    Transaction[] getAllTransactionsByUser(int userId) throws SQLException;
}
