package ir.maktab.service.cardService;

import ir.maktab.entity.Card;

import java.util.Date;

public interface CardService {
    boolean cardRegistration(Integer cardnumber,String cardType, Date expireddate, int cvv2, Integer shebanumber);
    boolean cardDeletion(Integer cardnumber);
    void displayBasedCardType(String cardType);
    void displayBasedBankName(String bankName);
    void showAllCards();
    Card findCardByCardNumber(int cardNumber);
}
