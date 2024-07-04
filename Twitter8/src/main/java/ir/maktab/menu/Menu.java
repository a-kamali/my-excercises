package ir.maktab.menu;

import ir.maktab.menu.login.LoginMenu;
import ir.maktab.menu.mainMenu.MainMenu;
import ir.maktab.menu.signupMenu.SignupMenu;
import ir.maktab.menu.util.Input;


import java.sql.SQLException;
import java.text.ParseException;

public class Menu {

    private final Input input;
    private final MainMenu mainMenu;
    private final SignupMenu signupMenu;
    private final LoginMenu loginMenu;


    public Menu(Input input, MainMenu mainMenu, SignupMenu signupMenu, LoginMenu loginMenu) {
        this.input = input;
        this.mainMenu = mainMenu;
        this.signupMenu = signupMenu;
        this.loginMenu = loginMenu;
    }

    public void show() throws SQLException, ParseException {
        System.out.println("Welcome to our Program");
        while (true) {
            mainMenu.show();
            switch (input.scanner.next()) {
                case "1": {
                    signupMenu.show();
                    break;
                }

                case "2": {
                    loginMenu.show();
                    break;
                }

                case "3": {
                    break;
                }

            }
        }

    }

}

//    private Input input = new Input();
//    DataSource dataSource = new DataSource();
//    private Connection connection = dataSource.getConnection() ;
//    private UserRepository userRepository = new UserRepositoryImpl(connection);
//    private UserService userService = new UserServiceImpl(userRepository);
//    private MainMenu mainMenu = new MainMenu();
//    private LoginMenu loginMenu = new LoginMenu();
