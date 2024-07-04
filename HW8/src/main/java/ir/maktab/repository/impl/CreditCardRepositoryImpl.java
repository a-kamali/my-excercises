package ir.maktab.repository.impl;


import ir.maktab.entity.CreditCard;
import ir.maktab.repository.BankAccountRepository;
import ir.maktab.repository.CreditCardRepository;
import java.sql.*;



public class CreditCardRepositoryImpl implements CreditCardRepository{
    private final Connection connection;
    private final BankAccountRepository bankAccountRepository;

    public CreditCardRepositoryImpl(Connection connection) {
        this.connection = connection;
        this.bankAccountRepository = bankAccountRepository;
    }


    @Override
    public void save(CreditCard creditCard) throws SQLException {
        String query = "INSERT INTO credit_cards (card_number, bank_name, user_id) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, creditCard.getCardNumber());
        statement.setString(2, creditCard.getBankName());
        statement.setInt(3, creditCard.getUserId());
        statement.executeUpdate();
    }


    @Override
    public void deleteByCardNumber(String cardNumber) throws SQLException {
        String query = "DELETE FROM credit_cards WHERE card_number = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cardNumber);
        statement.executeUpdate();
    }


    @Override
    public CreditCard findByCardNumber(String cardNumber) throws SQLException {
        String query = "SELECT * FROM credit_cards WHERE card_number = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cardNumber);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return new CreditCard(
                    resultSet.getInt("id"),
                    resultSet.getString("card_number"),
                    resultSet.getString("bank_name"),
                    resultSet.getInt("user_id")
            );
        }

        return null;
    }



    @Override
    public CreditCard[] findByBankName(String bankName) throws SQLException {
        String query = "SELECT * FROM credit_cards WHERE bank_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, bankName);
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        CreditCard[] creditCards = new CreditCard[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            CreditCard creditCard = new CreditCard(
                    resultSet.getInt("id"),
                    resultSet.getString("card_number"),
                    resultSet.getString("bank_name"),
                    resultSet.getInt("user_id")
            );
            creditCards[index] = creditCard;
            index++;
        }

        return creditCards;
    }


    @Override
    public CreditCard[] findAll() throws SQLException {
        String query = "SELECT * FROM credit_cards";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        CreditCard[] creditCards = new CreditCard[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            CreditCard creditCard = new CreditCard(
                    resultSet.getInt("id"),
                    resultSet.getString("card_number"),
                    resultSet.getString("bank_name"),
                    resultSet.getInt("user_id")
            );
            creditCards[index] = creditCard;
            index++;
        }

        return creditCards;
    }


    @Override
    public CreditCard[] findAllByUser(int userId) throws SQLException {
        String query = "SELECT * FROM credit_cards WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);
        ResultSet resultSet = statement.executeQuery();

        int size = 0;
        while (resultSet.next()) {
            size++;
        }

        CreditCard[] creditCards = new CreditCard[size];
        resultSet.beforeFirst();
        int index = 0;
        while (resultSet.next()) {
            CreditCard creditCard = new CreditCard(
                    resultSet.getInt("id"),
                    resultSet.getString("card_number"),
                    resultSet.getString("bank_name"),
                    resultSet.getInt("user_id")
            );
            creditCards[index] = creditCard;
            index++;
        }

        return creditCards;
    }

}
