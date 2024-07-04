package ir.maktab.menu.login;

import ir.maktab.menu.cardMenu.CardMenu;
import ir.maktab.menu.financialMenu.FinancialTransactions;
import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;

import java.text.ParseException;

public class LoginSubMenu {

    private final Input input;
    private final CardMenu cardMenu;
    private final FinancialTransactions financialTransactions;
    private final Message message;

    public LoginSubMenu(Input input, CardMenu cardMenu, FinancialTransactions financialTransactions, Message message) {
        this.input = input;
        this.cardMenu = cardMenu;
        this.financialTransactions = financialTransactions;
        this.message = message;
    }


    public void show() throws ParseException {
        System.out.println("""
                1 -> Card Transactions
                2 -> Financial Transactions
                3 -> Exit
                """);
        switch (input.scanner.next()){
            case "1": {
                cardMenu.show();
                break;
            }
            case "2":{
                financialTransactions.show();
                break;
            }
            case "3":{
                break;
            }
            default:
                System.out.println(message.getWrongInput() + " Number");

        }

    }
}
