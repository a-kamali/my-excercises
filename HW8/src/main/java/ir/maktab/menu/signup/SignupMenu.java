package ir.maktab.menu.signup;

import ir.maktab.menu.util.Input;
import ir.maktab.service.UserService;

public class SignupMenu {
    private final Input INPUT;

    public SignupMenu(Input INPUT) {
        this.INPUT = INPUT;

        while (true) {
            System.out.println("""
                    1 -> Enter Information
                    2 -> Previous Menu
                    """);

            switch (INPUT.scanner.next()) {
                case "1": {
                    String username = INPUT.scanner.next();
                    String password = INPUT.scanner.next();
                    if (UserService.signUp(username, password)) {
                        break;
                    }
                    break;
                }
                case "2": {
                    break;
                }


            }

        }
    }


}
