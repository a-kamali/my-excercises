package ir.maktab.service;

import ir.maktab.entity.BankAccount;

import java.sql.SQLException;

public interface BankAccountService {

    void createAccount(BankAccount bankAccount) throws SQLException;
    BankAccount getAccountByNumber(String accountNumber) throws SQLException;
}
