package ir.maktab.entity;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private int userId;

    public BankAccount(int id, String accountNumber, double balance, int userId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.userId = userId;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
