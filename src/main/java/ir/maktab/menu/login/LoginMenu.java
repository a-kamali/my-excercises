package ir.maktab.menu.login;

import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;
import ir.maktab.service.userService.UserService;

import java.sql.SQLException;
import java.text.ParseException;

public class LoginMenu {
    private final Input input;
    private final LoginSubMenu loginSubMenu;
    private final Message message;
    private final UserService userService;

    public LoginMenu(Input input, LoginSubMenu loginSubMenu, Message message, UserService userService) {
        this.input = input;
        this.loginSubMenu = loginSubMenu;
        this.message = message;
        this.userService = userService;
    }

    public void show() throws SQLException, ParseException {
        System.out.println("""
                1 -> Login
                2 -> Previous Menu
                """);
        switch (input.scanner.next()){
            case "1":{
                while (true) {
                    System.out.println(message.getInput() + "Username");
                    String username = input.scanner.next();
                    System.out.println(message.getInput() + "Password");
                    String password = input.scanner.next();
                    if (userService.Login(username, password)) {
                        loginSubMenu.show();
                        break;
                    } else {
                        System.out.println(message.getWrongInput() + "Username And Password");
                    }
                }
            }
            case "2": {
                break;
            }
            default:
                System.out.println(message.getWrongInput() + " Number");

        }
    }
}
