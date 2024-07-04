package ir.maktab;
import java.util.ArrayList;
import java.util.List;

    public class Wallet {
        private static int idCounter = 0;
        private int id;
        private List<Transaction> transactions;

        public Wallet() {
            this.id = ++idCounter;
            this.transactions = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public void addTransaction(Transaction transaction) {
            transactions.add(transaction);
            transaction.process();
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }

        public Transaction getTransactionById(int transactionId) {
            for (Transaction transaction : transactions) {
                if (transaction.getId() == transactionId) {
                    return transaction;
                }
            }
            return null;
        }

        public double getBalance() {
            double balance = 0;
            for (Transaction transaction : transactions) {
                if (transaction.getStatus() == Transaction.Status.SUCCESSFUL) {
                    if (transaction instanceof DepositTransaction) {
                        balance += transaction.getAmount();
                    } else if (transaction instanceof WithdrawalTransaction) {
                        balance -= transaction.getAmount();
                    }
                }
            }
            return balance;
        }

        public void deposit(double amount) {
            // پیاده‌سازی روش واریز به کیف پول
        }

        public void withdraw(double amount) {
            // پیاده‌سازی روش برداشت از کیف پول
        }

        @Override
        public String toString() {
            return "Wallet{" +
                    "id=" + id +
                    ", balance=" + getBalance() +
                    '}';
        }
    }

}
