package ir.maktab.repository.cardRepository;

import ir.maktab.entity.Account;
import ir.maktab.entity.Card;

import java.sql.SQLException;
import java.util.Date;

public interface CardRepository {

    public Card create(Integer accountID, int cardNumber, Date expiredDate,int cvv2,int shebaNumber) throws SQLException;

}
