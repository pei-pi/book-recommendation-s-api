package com.example.bookmanageback.entity;

public class Activity {
    private int bookId;
    private int borrowCount;
    private int collectCount;
    private int score;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getborrowCount() {
        return borrowCount;
    }

    public void setborrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public int getcollectCount() {
        return collectCount;
    }

    public void setcollectCount(int collectCount) {
        this.collectCount = collectCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "bookId=" + bookId +
                ", borrowCount=" + borrowCount +
                ", collectCount=" + collectCount +
                ", score=" + score +
                '}';
    }
}
