package ir.maktab.util;

import ir.maktab.config.DataSource;
import ir.maktab.domain.entities.Tweet;
import ir.maktab.domain.entities.User;
import ir.maktab.repository.tweet.TweetRepository;
import ir.maktab.repository.tweet.TweetRepositoryImpl;
import ir.maktab.repository.user.UserRepositoryImpl;
import ir.maktab.repository.user.UserRepositrory;
import ir.maktab.service.tweet.TweetService;
import ir.maktab.service.tweet.TweetServiceImpl;
import ir.maktab.service.user.UserServic;
import ir.maktab.service.user.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {


    private static final  ApplicationContext INSTANCE = new ApplicationContext();

    private static UserServic userServic;
    private static TweetService tweetService;

     private ApplicationContext() {
    }

    static {
        Connection connection = DataSource.getConnection();

        UserRepositrory userRepositrory = new UserRepositoryImpl(connection);
        TweetRepository tweetRepository = new TweetRepositoryImpl(connection);

        tweetService = new TweetServiceImpl(tweetRepository);
        userServic = new UserServiceImpl(userRepositrory,tweetService);
    }

    public static ApplicationContext getINSTANCE() {
        return INSTANCE;
    }

    public UserServic getUserServic() {
        return userServic;
    }

    public TweetService getTweetService() {
        return tweetService;
    }
}
