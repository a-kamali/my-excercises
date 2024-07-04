package ir.maktab.service;

import ir.maktab.entity.CreditCard;

import java.sql.SQLException;

public interface CreditCardService {
    void addCard(CreditCard creditCard) throws SQLException;
    CreditCard getCardByNumber(String cardNumber) throws SQLException;
    CreditCard[] getCardsByBank(String bankName) throws SQLException;
    CreditCard[] getAllCards() throws SQLException;
}
