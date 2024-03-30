package com.example.bookmanageback.entity;

import java.sql.Timestamp;

public class Collection {
    private int id;
    private int bookId;
    private int userId;
    private Timestamp collectionTime;

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

    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Timestamp collectTime) {
        this.collectionTime = collectTime;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", collectionTime=" + collectionTime +
                '}';
    }
}
