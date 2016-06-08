package com.example.iti.sidemenumodule.model;

import java.util.ArrayList;

/**
 * Created by ITI on 04/06/2016.
 */
public class Users {

    private Integer userId;
    private String userEmail;
    private String userImageUrl;
    private String password;
    private boolean gender;
    private String userName;
    private int ped;
    private String country;
    private String governorate;
    private String city;
    private String street;
    private String summery;

    public ArrayList<Skills> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(ArrayList<Skills> userSkills) {
        this.userSkills = userSkills;
    }

    private String professinalTiltle;
    private String identefire;
    private String token;
    private ArrayList<Skills> userSkills;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPed() {
        return ped;
    }

    public void setPed(int ped) {
        this.ped = ped;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGovernorate() {
        return governorate;
    }

    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public String getProfessinalTiltle() {
        return professinalTiltle;
    }

    public void setProfessinalTiltle(String professinalTiltle) {
        this.professinalTiltle = professinalTiltle;
    }

    public String getIdentefire() {
        return identefire;
    }

    public void setIdentefire(String identefire) {
        this.identefire = identefire;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getUserId() {

        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer rate;
}
