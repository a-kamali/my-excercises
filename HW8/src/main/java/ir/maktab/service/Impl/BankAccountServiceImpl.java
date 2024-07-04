package ir.maktab.service.Impl;

import ir.maktab.entity.BankAccount;
import ir.maktab.repository.BankAccountRepository;
import ir.maktab.service.BankAccountService;

import java.sql.SQLException;

public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void createAccount(BankAccount bankAccount) throws SQLException {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount getAccountByNumber(String accountNumber) throws SQLException {
        return bankAccountRepository.findByAccountNumber(accountNumber);
    }


}
