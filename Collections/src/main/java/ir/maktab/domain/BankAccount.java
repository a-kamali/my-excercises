package ir.maktab.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
public class BankAccount {
    Integer id;
    Integer accountNumber;
    Double balance;
    List<Transaction> transactionList = new ArrayList<>();



    public BankAccount(Integer accountNumber, Double balance, List<Transaction> transactionList) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactionList = transactionList;
    }
    public void deposit(Transaction transaction){
        balance += transaction.amount;
        transactionList.add(transaction);
    }
    public void withdraw(Transaction transaction){
        balance -= transaction.amount;
        transactionList.add(transaction);
    }
    public void getTransactions(){
        System.out.println(transactionList);
    }

}
