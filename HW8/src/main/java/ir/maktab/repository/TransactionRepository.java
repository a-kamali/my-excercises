package ir.maktab.repository;

import ir.maktab.entity.Transaction;
import java.sql.SQLException;

public interface TransactionRepository {
    void save(Transaction transaction) throws SQLException;
    Transaction[] findByType(String type) throws SQLException;
    Transaction[] findByDateRange(String startDate, String endDate) throws SQLException;
    Transaction[] findByAmountGreaterThan(double amount) throws SQLException;
    Transaction[] findAllByUser(int userId) throws SQLException;
}
