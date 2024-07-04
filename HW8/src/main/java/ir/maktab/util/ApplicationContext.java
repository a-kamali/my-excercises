package ir.maktab.util;

import ir.maktab.config.DataSource;
import ir.maktab.menu.Menu;
import ir.maktab.menu.creditCard.CreditCard;
import ir.maktab.menu.financialOperation.FinancialOperation;
import ir.maktab.menu.login.LoginMenu;
import ir.maktab.menu.login.LoginSubMenu;
import ir.maktab.menu.main.MainMenu;
import ir.maktab.menu.signup.SignupMenu;
import ir.maktab.menu.util.Input;

import ir.maktab.repository.UserRepository;
import ir.maktab.repository.impl.UserRepositoryImpl;
import ir.maktab.service.UserService;
import ir.maktab.service.Impl.UserServiceImpl;

import ir.maktab.repository.BankAccountRepository;
import ir.maktab.repository.impl.BankAccountRepositoryImpl;
import ir.maktab.service.BankAccountService;
import ir.maktab.service.Impl.BankAccountServiceImpl;

import ir.maktab.repository.CreditCardRepository;
import ir.maktab.repository.impl.CreditCardRepositoryImpl;
import ir.maktab.service.CreditCardService;
import ir.maktab.service.Impl.CreditCardServiceImpl;

import ir.maktab.repository.TransactionRepository;
import ir.maktab.repository.impl.TransactionRepositoryImpl;
import ir.maktab.service.TransactionService;
import ir.maktab.service.Impl.TransactionServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;


public class ApplicationContext {

    private static final ApplicationContext INSTANCE = new ApplicationContext();
        private static Menu menu;


        private ApplicationContext() throws SQLException {

            Connection connection = DataSource.getConnection();

            UserRepository userRepository = new UserRepositoryImpl(connection);
            UserService userService = new UserServiceImpl(userRepository);


            BankAccountRepository bankAccountRepository = new BankAccountRepositoryImpl(connection);;
            BankAccountService bankAccountService = new BankAccountServiceImpl(bankAccountRepository);

            CreditCardRepository creditCardRepository = new CreditCardRepositoryImpl(connection);
            CreditCardService creditCardService = new CreditCardServiceImpl(creditCardRepository);

            TransactionRepository transactionRepository = new TransactionRepositoryImpl(connection);
            TransactionService transactionService = new TransactionServiceImpl(transactionRepository) ;

            Input input = new Input();
            MainMenu MainMenu = new MainMenu();
            SignupMenu SignupMenu = new SignupMenu();
            LoginMenu LoginMenu = new LoginMenu();
            SignupMenu signupMenu = new SignupMenu(input, CreditCard , FinancialOperation);
            LoginSubMenu loginSubmenu = new LoginSubMenu(input, userService);
            LoginMenu loginMenu = new LoginMenu(input, loginSubmenu, userService);
            menu = new Menu(MainMenu,input, SignupMenu, LoginMenu);



        }

        public static ApplicationContext getInstance() {
            return instance;
        }

        public UserService getUserService() {
            return userService;
        }

        public BankAccountService getBankAccountService() {
            return bankAccountService;
        }

        public CreditCardService getCreditCardService() {
            return creditCardService;
        }

        public TransactionService getTransactionService() {
            return transactionService;
        }


    public Menu getMenu() {
        return menu;
    }
}
