package ir.maktab.menu.login;

import ir.maktab.menu.util.Input;
import ir.maktab.menu.util.Message;
import ir.maktab.service.user.UserService;
import ir.maktab.util.AuthHolder;

import java.sql.SQLException;

public class LoginMenu {
    private final Input input;
    private final Message message;
    private final UserService userService;
    private final LoginSubMenu loginSubMenu;
    private final AuthHolder authHolder;

    public LoginMenu(Input input, Message message, UserService userService, LoginSubMenu loginSubMenu, AuthHolder authHolder) {
        this.input = input;
        this.message = message;
        this.userService = userService;
        this.loginSubMenu = loginSubMenu;
        this.authHolder = authHolder;
    }

    public void show() throws SQLException {

       while (true){
           System.out.println("""
                   1 -> Enter Information
                   2 -> Previous Menu
                   """);

           switch (input.scanner.next()){

               case "1":{
                   System.out.println(message.getInputMessage("username: "));
                   String username = input.scanner.next();
                   System.out.println(message.getInputMessage("password: "));
                   String password = input.scanner.next();
                   if(userService.login(username,password)){
                       System.out.println(message.getSucessfulMessage("You Login "));
                       loginSubMenu.show();
                       authHolder.
                   }
               }

           }



       }
    }


}
