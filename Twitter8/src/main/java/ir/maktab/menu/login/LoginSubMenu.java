package ir.maktab.menu.login;

import ir.maktab.menu.cardOperation.CardMenu;
import ir.maktab.menu.financialMenu.FinancialMenu;
import ir.maktab.menu.util.Input;
import java.sql.SQLException;
import java.text.ParseException;

public class LoginSubMenu {
    private final Input input;
    private final CardMenu cardMenu;
    private final FinancialMenu financialMenu;

    public LoginSubMenu(Input input, CardMenu cardMenu, FinancialMenu financialMenu) {
        this.input = input;
        this.cardMenu = cardMenu;
        this.financialMenu = financialMenu;
    }

    public void show() throws SQLException, ParseException {
        System.out.println("""
                1 -> Card Operation
                2 -> Financial Operation
                3 -> Previous Menu
                """);
        switch (input.scanner.next()) {
            case "1": {
                cardMenu.show();
                break;
            }
            case "2":{
                financialMenu.show();
                break;
            }

        }
    }
}
