package com.example.bookmanageback.entity;

public class Category {
    private int categoryId;
    private int cateID;
    private String cateName;
    private int subCateID;
    private String subCateName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getSubCateID() {
        return subCateID;
    }

    public void setSubCateID(int subCateID) {
        this.subCateID = subCateID;
    }

    public String getSubCateName() {
        return subCateName;
    }

    public void setSubCateName(String subCateName) {
        this.subCateName = subCateName;
    }

    @Override
    public String toString() {
        return "category{" +
                "categoryId=" + categoryId +
                ", cateID=" + cateID +
                ", cateName='" + cateName + '\'' +
                ", subCateID=" + subCateID +
                ", subCateName='" + subCateName + '\'' +
                '}';
    }
}
