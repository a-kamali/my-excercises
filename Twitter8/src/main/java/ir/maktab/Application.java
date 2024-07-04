package ir.maktab;

import ir.maktab.config.DataSource;
import ir.maktab.menu.Menu;
import ir.maktab.menu.cardOperation.CardMenu;
import ir.maktab.menu.financialMenu.FinancialMenu;
import ir.maktab.menu.login.LoginMenu;
import ir.maktab.menu.login.LoginSubMenu;
import ir.maktab.menu.mainMenu.MainMenu;
import ir.maktab.menu.signupMenu.SignupMenu;
import ir.maktab.menu.util.Input;
import ir.maktab.repository.cardRepository.CardRepository;
import ir.maktab.repository.cardRepository.CardRepositoryImpl;
import ir.maktab.repository.userRepository.UserRepository;
import ir.maktab.repository.userRepository.UserRepositoryImpl;
import ir.maktab.service.cardService.CardService;
import ir.maktab.service.cardService.CardServiceImpl;
import ir.maktab.service.userService.UserService;
import ir.maktab.service.userService.UserServiceImpl;
import ir.maktab.util.ApplictionContext;
import ir.maktab.util.AuthHolder;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;


public class Application {
    public static void main(String[] args) throws SQLException, ParseException {
        Connection connection = new DataSource().getConnection();

        UserRepository userRepository = new UserRepositoryImpl(connection);
        CardRepository cardRepository = new CardRepositoryImpl(connection);

        UserService userService = new UserServiceImpl(userRepository);
        CardService cardService = new CardServiceImpl(cardRepository);

        Input input = new Input();
        MainMenu mainMenu = new MainMenu();
        AuthHolder authHolder = new AuthHolder();
        CardMenu cardMenu = new CardMenu(input,cardService);
        FinancialMenu financialMenu = new FinancialMenu();
        SignupMenu signupMenu = new SignupMenu(input,userService);
        LoginSubMenu loginSubMenu = new LoginSubMenu(input, cardMenu, financialMenu);
        LoginMenu loginMenu = new LoginMenu(input,userService,loginSubMenu);
        Menu menu = new Menu(input,mainMenu, signupMenu,loginMenu);
        menu.show();
    }
}