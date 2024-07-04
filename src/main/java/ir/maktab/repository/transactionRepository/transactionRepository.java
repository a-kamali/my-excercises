package ir.maktab.repository.transactionRepository;

import ir.maktab.entity.Transaction;

import java.sql.SQLException;

public interface transactionRepository {
    Transaction create(Integer originAccount_id, Integer destinationAccount_id, Double amount) throws SQLException;
    boolean update(Integer originAccount_id, Integer destinationAccount_id, Double amount);
}
