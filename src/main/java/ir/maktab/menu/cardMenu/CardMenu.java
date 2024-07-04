package ir.maktab.menu.cardMenu;

import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;
import ir.maktab.service.cardService.CardService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardMenu {

    private final Input input;
    private final CardService cardService;
    private final Message message;

    public CardMenu(Input input, CardService cardService, Message message) {
        this.input = input;
        this.cardService = cardService;
        this.message = message;
    }

    public void show() throws ParseException {
        System.out.println("""
                1 -> Card Registration
                2 -> Remove Card
                3 -> Bank Card Display Based On Card Type
                4 -> Display Bank Cards belonging to a specific bank based on the bank name
                5 -> Show all cards
                6 -> Display all transactions based on a specific filter
                7 -> View all transactions
                8 - Previous Menu
                """);

        switch (input.scanner.next()){
            case "1":{
                System.out.println("Card Registration");
                System.out.println(message.getInput() + " CardNumber");
                Integer cardnumber = input.scanner.nextInt();

                System.out.println(message.getInput() + " ExpiredDate(dd/mm/yyyy)");
                String dateString = input.scanner.next();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date expiredDate = sdf.parse(dateString);

                System.out.println(message.getInput() + " Cvv2");
                int cvv2 = input.scanner.nextInt();

                System.out.println(message.getInput() + " ShebaNumber");
                int shebaNumber = input.scanner.nextInt();

                System.out.println(message.getInput() + " CardType");
                String cardType = input.scanner.next();
                cardService.cardRegistration(cardnumber,cardType,expiredDate,cvv2,shebaNumber);
                break;
            }
            case "2":{
                System.out.println("Remove Card");
                System.out.println(message.getInput() +" CardNumber");
                Integer cardnumber = input.scanner.nextInt();
                boolean result = cardService.cardDeletion(cardnumber);
                if(result){
                    System.out.println(message.getSuccessfull() + " Deletion");
                }else {
                    System.out.println(message.getUnSuccessfull() +" Deletion" );
                }
                break;
            }
            case "3":{
                System.out.println("Bank Card Display Based On Card Type");
                System.out.println(message.getInput() + " Card Type");
                String cardType = input.scanner.next();
                cardService.displayBasedCardType(cardType);
                break;
            }
            case "4":{
                System.out.println("Display Bank Cards belonging to a specific bank based on the bank name");
                System.out.println(message.getInput() + " Bank Name");
                String bankName = input.scanner.next();
                cardService.displayBasedBankName(bankName);
                break;
            }
            case "5": {
                System.out.println("Show all cards");
                cardService.showAllCards();
                break;
            }
            case "6": {
                System.out.println("Display all transactions based on a specific filter");

                ???????
                break;
            }
            case "7":{
                System.out.println("View all transactions");

                ????????????
                break;
            }
            case "8":{
                break;
            }
            default:
                System.out.println(message.getWrongInput() + " Number");

        }
    }
}
