package ir.maktab;

import ir.maktab.Wallet;
import ir.maktab.enoumeration.Status;

public abstract class Transaction {

    protected static int idCounter = 0;
    protected final int id;
    protected final Wallet wallet;
    protected final double amount;
    Status status;

    public Transaction(Wallet wallet, double amount, Status status) {
        this.id = ++idCounter;
        this.wallet = wallet;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public double getAmount() {
        return amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public abstract void process();

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", wallet=" + wallet.getId() +
                ", amount=" + amount +
                ", status=" + status +
                '}';
    }
}
