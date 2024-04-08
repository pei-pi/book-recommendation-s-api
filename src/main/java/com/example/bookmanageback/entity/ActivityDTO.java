package com.example.bookmanageback.entity;

public class ActivityDTO {
    private int bookId;
    private int BorrowCount;
    private int CollectCount;
    private int score;
    private String bookTitle;
    private String bookAuthor;
    private String bookSrc;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBorrowCount() {
        return BorrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        BorrowCount = borrowCount;
    }

    public int getCollectCount() {
        return CollectCount;
    }

    public void setCollectCount(int collectCount) {
        CollectCount = collectCount;
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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookSrc() {
        return bookSrc;
    }

    public void setBookSrc(String bookSrc) {
        this.bookSrc = bookSrc;
    }

    @Override
    public String toString() {
        return "ActivityDTO{" +
                "bookId=" + bookId +
                ", BorrowCount=" + BorrowCount +
                ", CollectCount=" + CollectCount +
                ", score=" + score +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookSrc='" + bookSrc + '\'' +
                '}';
    }
}
