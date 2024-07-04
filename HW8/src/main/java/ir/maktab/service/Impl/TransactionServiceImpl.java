package ir.maktab.service.Impl;

import ir.maktab.entity.Transaction;
import ir.maktab.repository.TransactionRepository;
import ir.maktab.service.TransactionService;

import java.sql.SQLException;

public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void recordTransaction(Transaction transaction) throws SQLException {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction[] getTransactionsByType(String type) throws SQLException {
        return transactionRepository.findByType(type);
    }

    @Override
    public Transaction[] getTransactionsByDateRange(String startDate, String endDate) throws SQLException {
        return transactionRepository.findByDateRange(startDate, endDate);
    }

    @Override
    public Transaction[] getTransactionsByAmountGreaterThan(double amount) throws SQLException {
        return transactionRepository.findByAmountGreaterThan(amount);
    }

    @Override
    public Transaction[] getAllTransactionsByUser(int userId) throws SQLException {
        return transactionRepository.findAllByUser(userId);
    }
}
