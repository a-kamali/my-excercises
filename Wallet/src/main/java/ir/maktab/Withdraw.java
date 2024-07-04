package ir.maktab;

import ir.maktab.enoumeration.Status;

public class Withdraw extends Transaction{

    public Withdraw(Wallet wallet, double amount, Status status) {
        super(wallet, amount, status);
    }

    @Override
    public void process() {

    }
}
