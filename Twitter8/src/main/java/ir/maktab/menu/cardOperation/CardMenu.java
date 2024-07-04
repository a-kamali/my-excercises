package ir.maktab.menu.cardOperation;

import ir.maktab.menu.util.Input;
import ir.maktab.service.cardService.CardService;
import ir.maktab.util.AuthHolder;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardMenu {

    private final Input input;
    private final CardService cardService;

    public CardMenu(Input input, CardService cardService) {
        this.input = input;
        this.cardService = cardService;
    }

    public void show() throws SQLException, ParseException {
        CardMenu:
        System.out.println("You Entered Card Menu");


        System.out.println("""
                1 -> Card Registration
                2 -> Remove Card
                3 -> Bank Card Display Based On Card Name
                4 -> Display Bank Cards belonging to a specific bank based on the bank name
                5 -> Show all cards
                6 -> Display all transactions based on a specific filter
                7 -> View all  transactions
                8 - Previous Menu
                """);
        switch (input.scanner.next()){
            case "1":

                int accountID = AuthHolder.getTokenId();
                System.out.println("Please Enter CardNumber");
                int cardNumber = input.scanner.nextInt();
                System.out.println("Please Enter ExpiredDate(dd/mm/yyyy)");
                String dateString = input.scanner.next();
                SimpleDateFormat sdf =  new SimpleDateFormat("dd/mm/yyyy");
                Date expiredDate = sdf.parse(dateString);
                System.out.println("Please Enter cvv2");
                int cvv2 = input.scanner.nextInt();
                System.out.println("Please Enter shebaNumber");
                int shebaNumber = input.scanner.nextInt();
                cardService.create(accountID,cardNumber,expiredDate,cvv2,shebaNumber);
        }

    }
}
