package ir.maktab.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter

public class Transaction {
    private Integer id;
    private Account originAccount;
    private Account destinationAccount;
    private Double amount;
    private LocalDate date;
    private LocalTime time;

    public Transaction() {
    }

    public Transaction(Account originAccount, Account destinationAccount, Double amount) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }
}
