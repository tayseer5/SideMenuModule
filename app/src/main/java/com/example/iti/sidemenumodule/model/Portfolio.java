package com.example.iti.sidemenumodule.model;

/**
 * Created by Ahmed_telnet on 5/23/2016.
 */
public class Portfolio {
    int portofolioId;
    String portDescription;
    int userId;
    int image;
    int categoryId;
    public Portfolio(){}

    public Portfolio(int portofolioId, String portDescription, int userId, int image, int categoryId) {
        this.portofolioId = portofolioId;
        this.portDescription = portDescription;
        this.userId = userId;
        this.image = image;
        this.categoryId = categoryId;
    }

    public int getPortofolioId() {
        return portofolioId;
    }

    public void setPortofolioId(int portofolioId) {
        this.portofolioId = portofolioId;
    }

    public String getPortDescription() {
        return portDescription;
    }

    public void setPortDescription(String portDescription) {
        this.portDescription = portDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
