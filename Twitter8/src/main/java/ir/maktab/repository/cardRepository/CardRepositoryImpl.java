package ir.maktab.repository.cardRepository;

import ir.maktab.config.DataSource;
import ir.maktab.entity.Account;
import ir.maktab.entity.Card;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CardRepositoryImpl implements CardRepository{
    private Connection connection;

    public CardRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Card create(Integer accountID, int cardNumber, Date expiredDate, int cvv2, int shebaNumber) throws SQLException {
        Card card = new Card();
        String createQuery = """
                insert into accountCard(accountID,cardNumber,expiredDate,cvv2,shebaNumber)
                values(?,?,?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(createQuery
                                ,PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1,accountID);
        preparedStatement.setInt(2,cardNumber);
        preparedStatement.setDate(3, (java.sql.Date) expiredDate);
        preparedStatement.setInt(4,cvv2);
        preparedStatement.setInt(5,shebaNumber);

        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()) {
            card.setId(resultSet.getInt("id"));
            card.setAccount(resultSet.getInt("account_id"));
            card.setCardNumber(resultSet.getInt("cardNumber"));
            card.setExpiredDate(resultSet.getDate("expiredDate"));
            card.setCvv2(resultSet.getInt("cvv2"));
            card.setShebaNumber(resultSet.getInt("shebaNumber"));
        }
        return card;

    }
}
