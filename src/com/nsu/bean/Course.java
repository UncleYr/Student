package com.nsu.bean;

/**
 * @author yr
 * @date 2020/11/16 17:26
 */
public class Course {
    private Integer id;
    private String name;
    private String teacher;
    private String time;
    private String place;
    private Integer count;
    private Integer remainCount;

    public Course() {
    }

    public Course(Integer id, String name, String teacher, String time, String place, Integer count, Integer remainCount) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.time = time;
        this.place = place;
        this.count = count;
        this.remainCount = remainCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Integer remainCount) {
        this.remainCount = remainCount;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", time='" + time + '\'' +
                ", place='" + place + '\'' +
                ", count=" + count +
                ", remainCount=" + remainCount +
                '}';
    }
}
