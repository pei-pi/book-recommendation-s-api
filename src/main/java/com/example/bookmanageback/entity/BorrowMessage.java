package com.example.bookmanageback.entity;

import java.sql.Timestamp;

public class BorrowMessage {
    private Integer id;
    private String username;
    private int score;
    private String bookTitle;
    private String borrowTime;
    private String endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BorrowMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", score=" + score +
                ", bookTitle='" + bookTitle + '\'' +
                ", borrowTime=" + borrowTime +
                ", endTime=" + endTime +
                '}';
    }
}
