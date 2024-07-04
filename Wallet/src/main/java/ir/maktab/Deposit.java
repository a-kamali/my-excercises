package ir.maktab;

import ir.maktab.enoumeration.Status;

public class Deposit extends Transaction{
    public Deposit(Wallet wallet, double amount, Status status) {
        super(wallet, amount, status);
    }

    @Override
    public void process() {

    }
}
