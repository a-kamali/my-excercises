package ir.maktab.repository.cardRepository;

import ir.maktab.entity.Account;
import ir.maktab.entity.Card;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface CardRepository {

    Card create(Integer cardnumber,String cardType, Date expireddate, int cvv2, Integer shebanumber, Account account) throws SQLException;
    int remove(Integer cardnumber) throws SQLException;
    List<Card> findCardsByType(String cardType) throws SQLException;
    List<Card> findCardsByBankName(String bankName) throws SQLException;
    List<Card> findAll() throws SQLException;
    Card findCardByCardNumber(int cardNumber) throws SQLException;
}
