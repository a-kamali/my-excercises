package ir.maktab.util;

import ir.maktab.config.DataSource;
import ir.maktab.domain.Entity.User;
import ir.maktab.repository.user.UserRepository;
import ir.maktab.repository.user.UserRepositoryImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationContext {

    private final static ApplicationContext  INSTSNCE = new ApplicationContext();
    private static UserRepository userRepository;

    private ApplicationContext() {
    }

    static{
        Connection connection = DataSource.getConnection();
        UserRepository userRepository = new UserRepositoryImpl(connection);
        UserService userService = new UserServiceImpl(userRepository);






    }

    public static ApplicationContext getInstance() {return INSTSNCE;}
    public UserRepository getUserRepository() {
        return userRepository;
    }

}
