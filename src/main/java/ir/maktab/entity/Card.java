package ir.maktab.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter

public class Card {
    private Integer id;
    private Integer cardnumber;
    private Date expireddate;
    private int cvv2;
    private Integer shebanumber;
    private Account account;
    private String cardType;


    public Card() {
    }

    public Card(Integer cardnumber, Date expireddate, Integer id, int cvv2, Integer shebanumber, Account account, String cardType) {
        this.cardnumber = cardnumber;
        this.expireddate = expireddate;
        this.id = id;
        this.cvv2 = cvv2;
        this.shebanumber = shebanumber;
        this.account = account;
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardnumber=" + cardnumber +
                ", expireddate=" + expireddate +
                ", cvv2=" + cvv2 +
                ", shebanumber=" + shebanumber +
                ", account=" + account +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
