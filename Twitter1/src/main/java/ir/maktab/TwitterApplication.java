package ir.maktab;


import ir.maktab.domin.User;
import ir.maktab.util.ApplicationContext;

import java.sql.SQLException;

public class TwitterApplication {
    public static void main(String[] args) throws SQLException {

        User user = new User("AlirezaKamali","123456");
        ApplicationContext.getINSTANCE().getUserService().save(user);
    }
}