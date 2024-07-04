package ir.maktab.menu.login;

    import ir.maktab.menu.util.Input;
    import ir.maktab.service.UserService;

public class LoginMenu {

    private final Input INPUT;
    private final LoginSubMenu LOGINSUBMENU;

    public LoginMenu(Input INPUT, LoginSubMenu LOGINSUBMENU) {
        this.INPUT = INPUT;
        this.LOGINSUBMENU = LOGINSUBMENU;
    }

    public LoginMenu() {

    }

    public void show()  {
        login:
        while (true) {
            System.out.println("""
                    1 -> Enter Information
                    2 -> Previous Menu
                    """);

            switch (INPUT.scanner.next()) {
                case "1": {
                    System.out.println("Please Enter Your UserName");
                    String username = INPUT.scanner.next();
                    System.out.println("Please Enter Your Password");
                    String password = INPUT.scanner.next();

                    UserService UserService = null;
                    if (UserService.login(username, password)) {
                        LOGINSUBMENU.show();
                        break login;
                    }
                    break;
                }
                case "2": {
                    break login;
                }
            }

        }

    }
}
