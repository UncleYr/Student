package com.nsu.bean;

/**
 * @author yr
 * @date 2020/11/14 11:02
 */
public class User {
    private String id;
    private String username;
    private String password;
    private String gender;
    private String major;
    private String grade;
    private String tel;
    private String course;

    public User() {
    }

    public User(String id, String username, String password, String gender, String major, String grade, String tel,String course) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.major = major;
        this.grade = grade;
        this.tel = tel;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", tel='" + tel + '\'' +
                ", count=" + course +
                '}';
    }
}
