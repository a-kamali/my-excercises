package ir.maktab.repository;

import ir.maktab.entity.CreditCard;
import java.sql.SQLException;

public interface CreditCardRepository {
    void save(CreditCard creditCard) throws SQLException;
    void deleteByCardNumber(String cardNumber) throws SQLException;
    CreditCard findByCardNumber(String cardNumber) throws SQLException;
    CreditCard[] findByBankName(String bankName) throws SQLException;
    CreditCard[] findAll() throws SQLException;
    CreditCard[] findAllByUser(int userId) throws SQLException;
}
