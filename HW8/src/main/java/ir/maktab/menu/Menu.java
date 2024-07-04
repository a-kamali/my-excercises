package ir.maktab.menu;

import ir.maktab.menu.login.LoginMenu;
import ir.maktab.menu.signup.SignupMenu;
import ir.maktab.menu.util.Input;
import ir.maktab.menu.main.MainMenu;



public class Menu {
    private final MainMenu MAINMENU;
    private final Input INPUT;
    private final SignupMenu SIGNUP_MENU;
    private final LoginMenu LOGIN_MENU;

    public Menu(MainMenu MAINMENU, Input INPUT, SignupMenu SIGNUP_MENU, LoginMenu LOGIN_MENU) {
        this.MAINMENU = MAINMENU;
        this.INPUT = INPUT;
        this.SIGNUP_MENU = SIGNUP_MENU;
        this.LOGIN_MENU = LOGIN_MENU;
    }

    public void show(){
        while (true) {
            MAINMENU.show();
            switch (INPUT.scanner.next()) {
                case "1":
                    SIGNUP_MENU.show();
                    break;
                case "2":
                    LOGIN_MENU.show();
                    break;
                case "3":
                    System.exit(0);
                    break;
            }
        }
    }



}
