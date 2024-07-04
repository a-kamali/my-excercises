package ir.maktab.domain;

public class Tweet extends BaseDomain {
    private User user;
    private String tweet;

    public Tweet(int id, User user, String tweet) {
        super(id);
        this.user = user;
        this.tweet = tweet;
    }
}
