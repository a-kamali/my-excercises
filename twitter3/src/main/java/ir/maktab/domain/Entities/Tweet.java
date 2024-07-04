package ir.maktab.domain.Entities;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tweet {

    private Integer id;
    //private Integer userID;
    //استفاده از یک شیء User به جای userID اشاره دارد
    //ر واقع، این روش بیشتر با اصول شیءگرایی مطابقت دارد
    //زیرا به جای نگهداری تنها یک شناسه کاربر، از یک شیء کامل کاربر استفاده می‌شود.
    private User user;

    private String content;
    private LocalTime time;
    private LocalDate date;

    public Tweet() {

    }

    public Tweet(String content) {
        this.content = content;
    }

    public Tweet(Text content, User user) {
        this.content = String.valueOf(content);
        this.user = user;
        this.time = LocalTime.now();
        this.date = LocalDate.now();
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
        return String.valueOf(content);
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", date=" + date +
                '}';
    }
}
