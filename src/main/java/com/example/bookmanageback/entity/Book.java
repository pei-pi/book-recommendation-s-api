package com.example.bookmanageback.entity;

public class Book {
    private int id;
    private String book_title;
    private String book_author;
    private String book_tags;
    private String book_content;
    private String book_src;
    private int book_category;
    private int book_detailedCategory;
//    private double book_score;
//    private int book_scoreRate;
    private int borrow_times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_tags() {
        return book_tags;
    }

    public void setBook_tags(String book_tags) {
        this.book_tags = book_tags;
    }

    public String getBook_content() {
        return book_content;
    }

    public void setBook_content(String book_content) {
        this.book_content = book_content;
    }

    public String getBook_src() {
        return book_src;
    }

    public void setBook_src(String book_src) {
        this.book_src = book_src;
    }

    public int getBook_category() {
        return book_category;
    }

    public void setBook_category(int book_category) {
        this.book_category = book_category;
    }

    public int getBook_detailedCategory() {
        return book_detailedCategory;
    }

    public void setBook_detailedCategory(int book_detailedCategory) {
        this.book_detailedCategory = book_detailedCategory;
    }

    public int getBorrow_times() {
        return borrow_times;
    }

    public void setBorrow_times(int borrow_times) {
        this.borrow_times = borrow_times;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", book_title='" + book_title + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_tags='" + book_tags + '\'' +
                ", book_content='" + book_content + '\'' +
                ", book_src='" + book_src + '\'' +
                ", book_category=" + book_category +
                ", book_detailedCategory=" + book_detailedCategory +
                ", borrow_times=" + borrow_times +
                '}';
    }
}
