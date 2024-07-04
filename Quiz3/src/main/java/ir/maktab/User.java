package ir.maktab;

public class User {
    private final Integer id;
    private final String username;
    private final String password;


    public User(Integer id, String firstname, String lastname, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "The UserName : "+ id + " Belong to : Mr or Miss"+ username + " "+ password+
                "his/her username is: " + username + " And his password is "+ password;
    }
}
