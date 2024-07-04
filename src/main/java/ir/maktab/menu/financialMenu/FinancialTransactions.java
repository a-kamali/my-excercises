package ir.maktab.menu.financialMenu;

import ir.maktab.menu.util.Input;
import ir.maktab.service.transactionService.TransactionService;

public class FinancialTransactions {

    private final Input input;
    private final TransactionService transactionService;


    public void show(){
        System.out.println("""
               1- Normal money transfer (card to card)
               2- Individual PAYA money Transfer
               3- Batches PAYA money Transfer
               4- Satna money transfer
                """);

        switch (input.scanner.next()){
            case "1":
                System.out.println("Normal money transfer (card to card)");
                System.out.println("Which bank card do you want to transfer money from");
                int OrgingBankCard = input.scanner.nextInt();
                System.out.println("Which bank card do you want to transfer money to");
                int DestinationBankCard = input.scanner.nextInt();
                System.out.println("How much do you want to transfer money?");
                Double money = input.scanner.nextDouble();
                transactionService.createTransaction(OrgingBankCard,DestinationBankCard,money);

        }
    }
}
