package ir.maktab.util;


public class AuthHolder {
    private Integer userID;
    private String username;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void reset(){
        userID = null;
        username = null;
    }
}
