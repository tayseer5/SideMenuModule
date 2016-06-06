package com.example.iti.sidemenumodule.model;


public class Category {


    private Integer categoryId;
    private String categoryName;
    private String imageOfCategoryUrl;

    public Category(Integer categoryId, String imageOfCategoryUrl, String categoryName) {
        this.categoryId = categoryId;
        this.imageOfCategoryUrl = imageOfCategoryUrl;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageOfCategoryUrl() {
        return imageOfCategoryUrl;
    }

    public void setImageOfCategoryUrl(String imageOfCategoryUrl) {
        this.imageOfCategoryUrl = imageOfCategoryUrl;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}