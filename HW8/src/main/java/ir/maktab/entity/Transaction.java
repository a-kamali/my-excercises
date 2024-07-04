package ir.maktab.entity;

import java.util.Date;

public class Transaction {

    private Integer id;
    private String type;
    private double amount;
    private Date date;
    private int userId;

    public Transaction(int id, String type, double amount, Date date, int userId) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
