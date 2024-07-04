package ir.maktab.util;

import ir.maktab.config.DataSource;
import ir.maktab.repository.user.UserRepository;
import ir.maktab.repository.user.UserRepositoryImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {

    private static final  ApplicationContext INSTANCE = new ApplicationContext();
    private static UserService userService;

    private ApplicationContext() {
    }

    public static ApplicationContext getINSTANCE() {
        return INSTANCE;
    }

    static {
        Connection connection = DataSource.getConnection();
        UserRepository userRepository = new UserRepositoryImpl(connection);
        userService = new UserServiceImpl(userRepository);



    }

    public  UserService getUserService() {
        return userService;
    }
}
