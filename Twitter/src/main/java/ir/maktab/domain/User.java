package ir.maktab.domain;

public class User extends BaseDomain {
    public final static String users = "";
    private String name;
    private String email;
    private String password;

    public User(int id, String email, String password, String name) {
        super(id);
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
