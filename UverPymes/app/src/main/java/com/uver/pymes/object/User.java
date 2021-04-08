package com.uver.pymes.object;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String userImg;
    private String position;
    private String jobSeniority;
    private String hireDate;
    private String oldDate;
    private String lastEvaluation;

    private List<Skill> skills;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobSeniority() {
        return jobSeniority;
    }

    public void setJobSeniority(String jobSeniority) {
        this.jobSeniority = jobSeniority;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getOldDate() {
        return oldDate;
    }

    public void setOldDate(String oldDate) {
        this.oldDate = oldDate;
    }

    public String getLastEvaluation() {
        return lastEvaluation;
    }

    public void setLastEvaluation(String lastEvaluation) {
        this.lastEvaluation = lastEvaluation;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userImg='" + userImg + '\'' +
                '}';
    }
}
