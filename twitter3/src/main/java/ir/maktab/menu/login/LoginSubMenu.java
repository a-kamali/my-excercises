package ir.maktab.menu.login;

import ir.maktab.domain.Entities.Tweet;
import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;
import ir.maktab.service.user.UserService;

import java.sql.SQLException;

public class LoginSubMenu {

    private final Input input;
    private final Message message;
    private final UserService userService;

    public LoginSubMenu(Input input, Message message, UserService userService) {
        this.input = input;
        this.message = message;
        this.userService = userService;
    }

    public void show() throws SQLException {
        login_submenu:
        {

            while (true) {
                System.out.println("""
                        Enter one of the following option:
                        1 -> Create Tweet
                        2 -> Update Tweet
                        3 -> Delete Tweet
                        4 -> Previous Menu
                        """);
                switch (input.scanner.next()) {
                    case "1": {
                        System.out.println(message.getInputMessage("Text Of Tweet"));
                        String text = input.scanner.next();
                        if (userService.createTweet(new Tweet(text)) != null) {
                            System.out.println(message.getSucessfulMessage("Your Tweet created "));
                        } else {
                            System.out.println(message.getFailedMessage("Your Tweet created "));
                        }
                        break;
                    }
                    case "2": {
                        System.out.println(message.getInputMessage("Enter you New Content"));
                        String text = input.scanner.next();
                        System.out.println(message.getInputMessage("Enter your TweetID"));
                        String id = input.scanner.next();

                        if (userService.updateTweet(text, Integer.valueOf(id)) != null) {
                            System.out.println(message.getSucessfulMessage("Your Tweet Updated "));
                        } else {
                            System.out.println(message.getFailedMessage("Your Tweet Updated "));
                        }

                    }
                    case "3": {
                        System.out.println(message.getInputMessage("TweetID "));
                        String id = input.scanner.next();

                        if (userService.deleteTweetByID(Integer.valueOf(id))) {
                            System.out.println(message.getSucessfulMessage("Your Tweet deleted "));
                        } else {
                            System.out.println(message.getFailedMessage("Your Tweet deleted "));
                        }
                        break;
                    }
                    case "4": {
                        break login_submenu;
                    }

                    default:
                        System.out.println(message.getInvalidInputMessage("Entered Number"));

                }

            }
        }
    }

}
