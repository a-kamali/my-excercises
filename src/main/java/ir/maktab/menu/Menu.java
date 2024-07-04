package ir.maktab.menu;

import ir.maktab.menu.login.LoginMenu;
import ir.maktab.menu.mainMenu.MainMenu;
import ir.maktab.menu.signup.Signup;
import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;

import java.sql.SQLException;
import java.text.ParseException;

public class Menu {

    private final MainMenu mainMenu;
    private final Input input;
    private final Signup signup;
    private final LoginMenu loginMenu;
    private final Message message;

    public Menu(MainMenu mainMenu, Input input, Signup signup, LoginMenu loginMenu, Message message) {
        this.mainMenu = mainMenu;
        this.input = input;
        this.signup = signup;
        this.loginMenu = loginMenu;
        this.message = message;
    }

    public void show() throws SQLException, ParseException {
        System.out.println("Welcome to Our Program");
        mainMenu.show();
        while (true) {
            switch (input.scanner.next()) {
                case "1": {
                    signup.show();
                    break;
                }
                case "2": {
                    loginMenu.show();
                    break;
                }
                case "3": {
                    break;
                }
                default:
                    System.out.println(message.getWrongInput() + " Number");
            }
        }
    }
}
