package com.example.bookmanageback.entity;

public class UserBorrow {
    private int bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookSrc;
    private int borrowState;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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

    public int getBorrowState() {
        return borrowState;
    }

    public void setBorrowState(int borrowState) {
        this.borrowState = borrowState;
    }

    @Override
    public String toString() {
        return "UserBorrow{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookSrc='" + bookSrc + '\'' +
                ", borrowState=" + borrowState +
                '}';
    }
}
