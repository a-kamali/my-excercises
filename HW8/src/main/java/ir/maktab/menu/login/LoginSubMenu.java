package ir.maktab.menu.login;

import ir.maktab.menu.util.Input;
import ir.maktab.menu.creditCard.CreditCard;
import ir.maktab.menu.financialOperation.FinancialOperation;

public class LoginSubMenu {

    private final Input INPUT;
    private final CreditCard CreditCard;
    private final FinancialOperation FinancialOperation;

    public LoginSubMenu(Input INPUT, CreditCard CreditCard, FinancialOperation FinancialOperation) {
        this.INPUT = INPUT;
        this.CreditCard = CreditCard;
        this.FinancialOperation = FinancialOperation;
    }

    public void show() {

        while (true) {

            System.out.println("""
                    1 -> Card Operation
                    2 -> Financial Operation
                    3 -> Exit
                    """);

            switch (INPUT.scanner.next()) {
                case "1": {
                    CreditCard.show();
                    break;
                }
                case "2": {
                    FinancialOperation.show();
                    break;
                }
                case "3": {
                    System.exit(0);
                    break;
                }

            }

        }

    }
}
