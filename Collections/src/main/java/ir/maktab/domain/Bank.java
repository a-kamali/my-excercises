package ir.maktab.domain;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    Integer id;
    Map<Integer,BankAccount> accounts = new HashMap<>();

    public void createAccount(BankAccount bankAccount){
        accounts.put(bankAccount.getAccountNumber(),bankAccount);
    }
    public void deposit(Double amount){
        if()
    }
}
