package ir.maktab.repository.accountRepository;

import ir.maktab.entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepositoryImpl implements AccountRepository {
    private Connection connection;

    @Override
    public Account findBySheba(Integer shebanumber) throws SQLException {
        Account account = new Account();
        String findQuery = """
                Select * from accounts
                where sheba = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setInt(1,shebanumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            account.setId(resultSet.getInt("id"));
            account.setId(resultSet.getInt("user_id"));
            account.setId(resultSet.getInt("bank_id"));
            account.setId(resultSet.getInt("sheba"));
            account.setBalance(resultSet.getDouble("balance"));
        }
        preparedStatement.close();
        connection.close();
        return account;
    }

    @Override
    public boolean update(int account_id, Double balance) throws SQLException {
        String updateQuery = """
                UPDATE accounts
                    set balance + ? 
                        where user_id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setInt(1,account_id);
        preparedStatement.setDouble(2,balance);
        return preparedStatement.execute();
    }

    @Override
    public Double findBalance(Integer accountID) throws SQLException {
        String findQuery = """
                Select balance from accounts
                where id = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(findQuery);
        preparedStatement.setInt(1,accountID);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getDouble("balance");

    }
}
