package ir.maktab.domain.entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tweet {

    private Integer id;
    private String content;
    private LocalDate createDate;
    private LocalTime createTime;
    private Integer userID;

    public Tweet(String content) {
        this.content = content;
    }

    public Tweet(Integer userID, String content) {
        this.userID = userID;
        this.content = content;
        this.createDate = LocalDate.now();
        this.createTime = LocalTime.now();
    }

    public Tweet() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", createTime=" + createTime +
                ", userID=" + userID +
                '}';
    }
}
