package ir.maktab.util;

import ir.maktab.config.DataSource;
import ir.maktab.repository.tweet.TweetRepository;
import ir.maktab.repository.tweet.TweetRepositoryImpl;
import ir.maktab.repository.user.UserRepository;
import ir.maktab.repository.user.UserRepositoryImpl;
import ir.maktab.service.tweet.TweetService;
import ir.maktab.service.tweet.TweetServiceImpl;
import ir.maktab.service.user.UserService;
import ir.maktab.service.user.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {

    private final static ApplicationContext INSTANCE = new ApplicationContext();
    private  static UserService userService;
    private static TweetService tweetService;


    private ApplicationContext() {
    }



    static {
        Connection connection = DataSource.getConnection();
        UserRepository userRepository = new UserRepositoryImpl(connection);
        TweetRepository tweetRepository = new TweetRepositoryImpl(connection);

        UserService userService = new UserServiceImpl(userRepository);
        TweetService tweetService = new TweetServiceImpl(tweetRepository);



    }


    public static ApplicationContext getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static TweetService getTweetService() {
        return tweetService;
    }
}
