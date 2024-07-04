package ir.maktab.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Transaction {
    Integer id;
    TransactionType transactionType;
    Double amount;

    public Transaction(TransactionType transactionType, Double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }
}
