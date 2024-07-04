package ir.maktab.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bank {
    private Integer id;
    private String name;

    public Bank(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
