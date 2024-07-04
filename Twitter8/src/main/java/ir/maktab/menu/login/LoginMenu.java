package ir.maktab.menu.login;

import ir.maktab.menu.util.Input;
import ir.maktab.service.userService.UserService;
import ir.maktab.util.AuthHolder;

import java.sql.SQLException;
import java.text.ParseException;

public class LoginMenu {
    private final Input input;
    private final UserService userService;
    private final LoginSubMenu loginSubMenu;


    public LoginMenu(Input input, UserService userService, LoginSubMenu loginSubMenu) {
        this.input = input;
        this.userService = userService;
        this.loginSubMenu = loginSubMenu;
    }

    public void show() throws SQLException, ParseException {
        while (true) {
        System.out.println("""
                1 -> Enter Information
                2 -> Previous Menu
                """);
            System.out.println("Pls Enter Your Username");
            String username = input.scanner.next();
            System.out.println("Pls Enter Your Password");
            String password = input.scanner.next();
            if (userService.checkUsernameAndPassword(username, password)) {
                userService.Login(username, password);
                System.out.println("You Entered Successfully");
                loginSubMenu.show();
                break;
            }else {
                System.out.println("You Entered Wrong Information");
            }
        }
    }
}
