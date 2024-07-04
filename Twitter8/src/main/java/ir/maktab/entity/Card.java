package ir.maktab.entity;

import java.util.Date;

public class Card {
    private Integer id;
    private Integer account;
    private int cardNumber;
    private Date expiredDate;
    private int cvv2;
    private int shebaNumber;

    public Card() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Integer getCvv2() {
        return cvv2;
    }

    public void setCvv2(Integer cvv2) {
        this.cvv2 = cvv2;
    }

    public int getShebaNumber() {
        return shebaNumber;
    }

    public void setShebaNumber(int shebaNumber) {
        this.shebaNumber = shebaNumber;
    }
}
