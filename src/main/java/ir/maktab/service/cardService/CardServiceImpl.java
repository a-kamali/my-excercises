package ir.maktab.service.cardService;

import ir.maktab.entity.Account;
import ir.maktab.entity.Card;
import ir.maktab.repository.cardRepository.CardRepository;
import ir.maktab.service.accountService.AccountService;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final AccountService accountService;

    public CardServiceImpl(CardRepository cardRepository, AccountService accountService) {
        this.cardRepository = cardRepository;
        this.accountService = accountService;
    }

    @Override
    public boolean cardRegistration(Integer cardnumber,String cardType, Date expireddate, int cvv2, Integer shebanumber) {
        Card card = null;
        try {
            Account account = accountService.findByShebaNumber(shebanumber);
            card = cardRepository.create(cardnumber,cardType,expireddate,cvv2,shebanumber,account);
        } catch (SQLException e) {
            System.out.println("You entered the wrong card information !!!");
        }
        return card != null;
    }



    @Override
    public boolean cardDeletion(Integer cardnumber) {
        try {
            return cardRepository.remove(cardnumber) > 0;
        } catch (SQLException e) {
            System.out.println("This CardNumber is not Available");
        }
        return false;
    }

    @Override
    public void displayBasedCardType(String cardType) {
        try {
            List<Card> cards = cardRepository.findCardsByType(cardType);
            for (Card card:cards){
                Account account = accountService.findByShebaNumber(card.getShebanumber());
                card.setAccount(account);
                System.out.println(card);
            }

        } catch (SQLException e) {
            System.out.println("This Card Type is not Available");
        }
    }

    @Override
    public void displayBasedBankName(String bankName) {
        try {
            List<Card> cards = cardRepository.findCardsByBankName(bankName);
            for (Card card : cards){
                Account account = accountService.findByShebaNumber(card.getShebanumber());
                card.setAccount(account);
                System.out.println(card);
            }
        } catch (SQLException e) {
            System.out.println("This Bank Name is not Available");
        }
    }

    @Override
    public void showAllCards() {
        try {
            List<Card> cards = cardRepository.findAll();
            for (Card card : cards){
                Account account = accountService.findByShebaNumber(card.getShebanumber());
                card.setAccount(account);
                System.out.println(card);
            }
        } catch (SQLException e) {
            System.out.println("This Bank Name is not Available");
        }
    }

    @Override
    public Card findCardByCardNumber(int cardNumber) {
        try {
            return cardRepository.findCardByCardNumber(cardNumber);
        } catch (SQLException e) {
            System.out.println("Your CardNumber is not Available");;
        }
        return null;
    }
}
