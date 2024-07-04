package ir.maktab.repository.cardRepository;

import ir.maktab.entity.Account;
import ir.maktab.entity.Card;
import ir.maktab.util.AuthHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private final Connection connection;

    public CardRepositoryImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Card create(Integer cardnumber,String cardType, Date expireddate, int cvv2, Integer shebanumber, Account account) throws SQLException {
        Card card = new Card();
        String addQuery = """
                insert into cards(cardnumber,cardtype, expireddate,cvv2,shebanumber,account_id) 
                values(?,?,?,?,?,?)        
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(addQuery,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, cardnumber);
        preparedStatement.setString(3, cardType);
        preparedStatement.setDate(2, (java.sql.Date) expireddate);
        preparedStatement.setInt(3, cvv2);
        preparedStatement.setInt(4, shebanumber);
        preparedStatement.setInt(5, AuthHolder.getInstance().getTokenId());

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            card.setId(resultSet.getInt("id"));
            card.setAccount(account);
            card.setCardnumber(resultSet.getInt("cardnumber"));
            card.setCvv2(resultSet.getInt("cvv2"));
            card.setExpireddate(resultSet.getDate("expireddate"));
            card.setShebanumber(resultSet.getInt("shebanumber"));
            card.setCardType(resultSet.getString("cardtype"));
        }
        preparedStatement.close();
        connection.close();
        return card;
    }

    @Override
    public int remove(Integer cardnumber) throws SQLException {
        String deleteQuery = """
                DELETE FROM cards WHERE cardnumber = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1,cardnumber);
        return preparedStatement.executeUpdate();

    }

    @Override
    public List<Card> findCardsByType(String cardType) throws SQLException {
        List<Card> cards = new ArrayList<>();
        String findQuery = """
                Select * from cards where cardtype =?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setString(1,cardType);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Card card = new Card();
            card.setId(resultSet.getInt("id"));
            card.setCardnumber(resultSet.getInt("cardnumber"));
            card.setCvv2(resultSet.getInt("cvv2"));
            card.setExpireddate(resultSet.getDate("expireddate"));
            card.setShebanumber(resultSet.getInt("shebanumber"));
            card.setCardType(resultSet.getString("cardtype"));
            cards.add(card);
        }
        return cards;
    }

    @Override
    public List<Card> findCardsByBankName(String bankName) throws SQLException {
        List<Card> cards = new ArrayList<>();
        String findQuery = """
                select c.id,c.account_id,c.cardnumber,c.expireddate,c.cvv2,c.shebanumber,c.cardtype from cards c
                join public.accounts a on a.id = c.account_id
                join public.banks b on b.id = a.bank_id
                where b.name = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setString(1,bankName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Card card = new Card();
            card.setId(resultSet.getInt("id"));
            card.setCardnumber(resultSet.getInt("cardnumber"));
            card.setCvv2(resultSet.getInt("cvv2"));
            card.setExpireddate(resultSet.getDate("expireddate"));
            card.setShebanumber(resultSet.getInt("shebanumber"));
            card.setCardType(resultSet.getString("cardtype"));
            cards.add(card);
        }
        return cards;
    }

    @Override
    public List<Card> findAll() throws SQLException {
        List<Card> cards = new ArrayList<>();
        String findQuery = "Select * from cards";
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Card card = new Card();
            card.setId(resultSet.getInt("id"));
            card.setCardnumber(resultSet.getInt("cardnumber"));
            card.setCvv2(resultSet.getInt("cvv2"));
            card.setExpireddate(resultSet.getDate("expireddate"));
            card.setShebanumber(resultSet.getInt("shebanumber"));
            card.setCardType(resultSet.getString("cardtype"));
            cards.add(card);
        }
        return cards;
    }

    @Override
    public Card findCardByCardNumber(int cardNumber) throws SQLException {
        Card card = new Card();
        String findQuery = """
                Select * from cards
                where cardnumber = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setInt(1,cardNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            card.setId(resultSet.getInt("id"));
            card.setCardnumber(resultSet.getInt("cardnumber"));
            card.setCvv2(resultSet.getInt("cvv2"));
            card.setExpireddate(resultSet.getDate("expireddate"));
            card.setShebanumber(resultSet.getInt("shebanumber"));
            card.setCardType(resultSet.getString("cardtype"));
        }

        return card;
    }
}

