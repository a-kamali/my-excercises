package ir.maktab.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Integer id;
    private User user;
    private Bank bank;
    private Integer sheba;
    private double balance;

    public Account() {
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user=" + user +
                ", bank=" + bank +
                ", sheba=" + sheba +
                ", balance=" + balance +
                '}';
    }
}
