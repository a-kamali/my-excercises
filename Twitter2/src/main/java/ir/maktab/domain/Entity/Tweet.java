package ir.maktab.domain.Entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tweet {
    private int id;
    private String content;
    private User user;
    private LocalDate date;
    private LocalTime time;
    public Tweet() {}

    public Tweet(String content, User user) {
        this.content = content;
        this.user = user;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
