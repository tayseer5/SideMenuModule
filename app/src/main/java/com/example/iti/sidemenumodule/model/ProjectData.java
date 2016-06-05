package com.example.iti.sidemenumodule.model;

/**
 * Created by ITI on 01/06/2016.
 */
public class ProjectData {
    int presentgeOfFinsh;
    String projectName;
    String state;
    String startDate;
    String endDate;


    String supplerName;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    String salary;
    public String getSupplerName() {
        return supplerName;
    }

    public void setSupplerName(String supplerName) {
        this.supplerName = supplerName;
    }



    public ProjectData(int presentgeOfFinsh, String projectName, String state, String startDate, String endDate, String supplerName, String salary) {
        this.presentgeOfFinsh = presentgeOfFinsh;
        this.projectName = projectName;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
        this.supplerName = supplerName;
    }

    public int getPresentgeOfFinsh() {
        return presentgeOfFinsh;
    }

    public void setPresentgeOfFinsh(int presentgeOfFinsh) {
        this.presentgeOfFinsh = presentgeOfFinsh;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
