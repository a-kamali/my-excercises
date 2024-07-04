package ir.maktab.domin;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Tweet {
    private Integer id;
    private String content;
    private LocalDate date;
    private LocalDateTime time;
    private User user; // private User userId


    public Tweet() {};
    public Tweet(String content, User user) {
        this.content = content;
        this.user = user;
        this.date = LocalDate.now();
        this.time = LocalDateTime.now();

    }

    public Integer getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", user=" + user +
                '}';
    }
}
