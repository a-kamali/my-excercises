package ir.maktab.service.accountService;

import ir.maktab.entity.Account;
import ir.maktab.repository.accountRepository.AccountRepository;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByShebaNumber(Integer shebaNumber) {
        try {
            return accountRepository.findBySheba(shebaNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Double findBalance(Integer accountID) {
        try {
            return accountRepository.findBalance(accountID);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateBalance(Integer accountID, Double balance) {
        try {
            return accountRepository.update(accountID,balance);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
