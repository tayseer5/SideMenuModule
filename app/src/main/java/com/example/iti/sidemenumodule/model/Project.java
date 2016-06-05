package com.example.iti.sidemenumodule.model;

import java.util.Date;

/**
 * Created by Ahmed_telnet on 5/31/2016.
 */
public class Project {
    private int category;
    private int users;
    private String projectSkills;
    private String projectName;
    private String projectDescription;
    private int budget;
    private Date startDate;
    private Date projectDeadLine;

    public Project() {
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getProjectDeadLine() {
        return projectDeadLine;
    }

    public void setProjectDeadLine(Date projectDeadLine) {
        this.projectDeadLine = projectDeadLine;
    }

    public String getProjectSkills() {
        return projectSkills;
    }

    public void setProjectSkills(String projectSkills) {
        this.projectSkills = projectSkills;
    }
}
