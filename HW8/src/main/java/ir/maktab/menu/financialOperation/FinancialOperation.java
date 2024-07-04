package ir.maktab.menu.financialOperation;

import ir.maktab.menu.util.Input;

public class FinancialOperation {
    private final Input INPUT;

    public FinancialOperation(Input INPUT) {
        this.INPUT = INPUT;
    }

    public void show() {
        while (true) {
            System.out.println("""
                    1 -> Normal Transfer (Card-to-Card)
                    2 -> PAYA Transfer (Personal)
                    3 -> PAYA Transfer (Batch)
                    4 -> SATNA Transfer
                    5 -> Previous Menu
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

                }

            }
        }
}
