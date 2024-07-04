package ir.maktab.domin.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tweet {
    private Integer id;
    private User user;
    private String content;
    private LocalDate date;
    private LocalTime time;

    public Tweet(User user, String content) {
        this.user = user;
        this.content = content;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                ", user=" + user +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
