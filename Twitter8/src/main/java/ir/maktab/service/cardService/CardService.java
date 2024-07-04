package ir.maktab.service.cardService;

import ir.maktab.entity.Card;

import java.sql.SQLException;
import java.util.Date;

public interface CardService {
    public Card create(Integer accountID, int cardNumber, Date expiredDate, int cvv2, int shebaNumber) throws SQLException;
}
