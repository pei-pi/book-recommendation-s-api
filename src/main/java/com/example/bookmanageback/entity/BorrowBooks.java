package com.example.bookmanageback.entity;

import java.sql.Timestamp;

public class BorrowBooks {
    private int id;
    private int bookId;
    private int userId;
    private Timestamp borrowTime;
    private Timestamp endTime;
    private int borrowState;
    private Timestamp returnTime;
    private int returnState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Timestamp borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public int getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(int borrowState) {
        this.borrowState = borrowState;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getReturnState() {
        return returnState;
    }

    public void setReturnState(int returnState) {
        this.returnState = returnState;
    }

    @Override
    public String toString() {
        return "BorrowBooks{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", borrowTime=" + borrowTime +
                ", endTime=" + endTime +
                ", borrowState=" + borrowState +
                ", returnTime=" + returnTime +
                ", returnState=" + returnState +
                '}';
    }
}
