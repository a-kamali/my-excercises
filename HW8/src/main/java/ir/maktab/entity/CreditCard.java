package ir.maktab.entity;

public class CreditCard {

    private String cardNumber;
    private String bankName;
    private Integer userId;

    public CreditCard(int id, String cardNumber, String bankName, int userId) {
        this.cardNumber = cardNumber;
        this.bankName = bankName;
        this.userId = userId;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
