package com.example.bookmanageback.entity;

public class Book {
    private int id;
    private String bookTitle;
    private String bookAuthor;
    private String bookTags;

    private String bookContent;
    private String bookSrc;
    private String bookCategory;
    private String bookDetailCategory;
    private int store;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBookTags() {
        return bookTags;
    }

    public void setBookTags(String bookTags) {
        this.bookTags = bookTags;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public String getBookSrc() {
        return bookSrc;
    }

    public void setBookSrc(String bookSrc) {
        this.bookSrc = bookSrc;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookDetailCategory() {
        return bookDetailCategory;
    }

    public void setBookDetailCategory(String bookDetailCategory) {
        this.bookDetailCategory = bookDetailCategory;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookTags='" + bookTags + '\'' +
                ", bookContent='" + bookContent + '\'' +
                ", bookSrc='" + bookSrc + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookDetailCategory='" + bookDetailCategory + '\'' +
                ", store=" + store +
                '}';
    }
}
