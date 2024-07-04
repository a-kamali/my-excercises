package ir.maktab.service.Impl;

import ir.maktab.entity.CreditCard;
import ir.maktab.repository.CreditCardRepository;
import ir.maktab.service.CreditCardService;

import java.sql.SQLException;

public class CreditCardServiceImpl implements CreditCardService {

    private CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public void addCard(CreditCard creditCard) throws SQLException {
        creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard getCardByNumber(String cardNumber) throws SQLException {
        return creditCardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public CreditCard[] getCardsByBank(String bankName) throws SQLException {
        return creditCardRepository.findByBankName(bankName);
    }

    @Override
    public CreditCard[] getAllCards() throws SQLException {
        return creditCardRepository.findAll();
    }


}
