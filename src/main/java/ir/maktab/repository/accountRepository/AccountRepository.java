package ir.maktab.repository.accountRepository;

import ir.maktab.entity.Account;

import java.sql.SQLException;

public interface AccountRepository {

    Account findBySheba(Integer shebanumber) throws SQLException;
    Double findBalance(Integer accountID) throws SQLException;
    boolean update(int account_id,Double balance) throws SQLException;
}
