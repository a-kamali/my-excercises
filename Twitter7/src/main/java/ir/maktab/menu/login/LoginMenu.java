package ir.maktab.menu.login;

import ir.maktab.domin.entity.User;
import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;
import ir.maktab.service.user.UserService;

import java.sql.SQLException;

public class LoginMenu {
    private final Input INPUT;
    private final Message MESSAGE;
    private final UserService userService;


    public void show() throws SQLException {
        System.out.println("""
                1 -> Enter Information
                2 -> Previous Menu
                """);
        switch (INPUT.scanner.next()){
            case "1":
                System.out.println(MESSAGE.getGetData()+"username");
                String username = INPUT.scanner.next();
                System.out.println(MESSAGE.getGetData()+"password");
                String password = INPUT.scanner.next();
                if(userService.findUserByUernameAndPassword(username,password));
                if(us)


        }

    }


}
