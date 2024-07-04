package ir.maktab.menu.signupMenu;

import ir.maktab.menu.util.Input;
import ir.maktab.service.userService.UserService;

import java.sql.SQLException;


public class SignupMenu {

    private final Input input;
    private final UserService userService;

    public SignupMenu(Input input, UserService userService) {
        this.input = input;
        this.userService = userService;
    }

    public void show() throws SQLException {
            while (true) {
                System.out.println("Pls Enter Your Username");
                String username = input.scanner.next();
                System.out.println("Pls Enter Your Password");
                String password = input.scanner.next();
                if (userService.isUsernameAvailable(username)) {
                    userService.signUp(username, password);
                    break ;
                }
            }
    }
}
