package ir.maktab.menu.signup;

import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;
import ir.maktab.service.userService.UserService;

import java.sql.SQLException;

public class Signup {
    private final Input input;
    private final Message message;
    private final UserService userService;

    public Signup(Input input, Message message, UserService userService) {
        this.input = input;
        this.message = message;
        this.userService = userService;
    }

    public void show() throws SQLException {
        System.out.println("""
                1 -> Enter Information
                2 -> Previous Menu
                """);
        switch (input.scanner.next()) {
            case "1": {
                String username;
                while (true) {
                    System.out.println(message.getInput() + "Username");
                    String requestedUsername = input.scanner.next();
                    if (userService.isUsernameAvailable(requestedUsername)) {
                        System.out.println("Please Enter another Username");
                    }else {
                        username = requestedUsername;
                        break;
                    }
                }
                System.out.println(message.getInput() + "Password");
                String password = input.scanner.next();

                userService.createUser(username, password);

                System.out.println(message.getSuccessfull() + "Signup");
                break;
            }
            case "2":{
                break;
            }
            default:
                System.out.println(message.getWrongInput()+"Number");
        }
    }
}
