package ir.maktab.service.cardService;

import ir.maktab.entity.Card;
import ir.maktab.repository.cardRepository.CardRepository;

import java.sql.SQLException;
import java.util.Date;

public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(Integer accountID, int cardNumber, Date expiredDate, int cvv2, int shebaNumber) throws SQLException {
//        if(Integer.toString(cardNumber).length() > 16 &&
//                Integer.toString(cvv2).length()== 4 &&
//                Integer.toString(shebaNumber).length() == 24){
            return cardRepository.create(accountID,cardNumber,expiredDate,cvv2,shebaNumber);
    }
}
