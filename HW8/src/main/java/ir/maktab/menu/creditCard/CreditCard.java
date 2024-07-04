package ir.maktab.menu.creditCard;

import ir.maktab.menu.util.Input;

public class CreditCard {
    private final Input INPUT;

    public CreditCard(Input INPUT) {
        this.INPUT = INPUT;
    }

    public void show() {
        while (true) {
            System.out.println("""
                    1 -> Register a card
                    2 -> Delete a card
                    3 -> Show a bank card by card name
                    4 -> Show bank cards belonging to a specific bank by bank name
                    5 -> Show all bank cards
                    6 -> Show all transactions based on a specific filter
                    7 -> Show all transactions of the user
                    8 -> Previous Menu
                    """);
            switch (INPUT.scanner.next()) {
                case "1": {
                    System.out.println("Please Enter Your UserName");
                }
                case "2": {
                    System.out.println("Please Enter Your UserName");
                }
                case "3": {
                    System.out.println("Please Enter Your UserName");
                }
                case "4": {
                    System.out.println("Please Enter Your UserName");
                }
                case "5": {
                    System.out.println("Please Enter Your UserName");
                }
                case "6": {
                    System.out.println("Please Enter Your UserName");
                }
                case "7": {
                    System.out.println("Please Enter Your UserName");
                }
                case "8": {
                    System.out.println("Please Enter Your UserName");
                }
                case "9": {
                    System.out.println("Please Enter Your UserName");
                }

            }
        }
   }
}
