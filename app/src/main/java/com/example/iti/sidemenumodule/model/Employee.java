package com.example.iti.sidemenumodule.model;

/**
 * Created by Ahmed_telnet on 5/25/2016.
 */
public class Employee {
    private String name;
    private String title;
    private double rate;
    private int image;

    public Employee(String name, String title, double rate, int image) {
        this.name = name;
        this.title = title;
        this.rate = rate;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
