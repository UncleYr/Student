package com.nsu.test;

import com.nsu.bean.Course;
import com.nsu.dao.CourseDao;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author yr
 * @date 2020/11/16 19:13
 */
public class CourseDaoTest {
    private CourseDao courseDao = new CourseDao();
    @Test
    public void addCourse() {
        courseDao.addCourse(new Course(null,"大学生恋爱手册","高老师","9-1-2050 19:00","A3",60,60));

    }

    @Test
    public void deleteCourseById() {

    }

    @Test
    public void updateCourse() {
        courseDao.updateCourse(new Course(3,"如何提高英语","高老师","9-1-2050 19:00","A3",60,60));
    }

    @Test
    public void queryCourseById() {
        System.out.println(courseDao.queryCourseById(2));
    }

    @Test
    public void queryCourses() {
        for (Course course : courseDao.queryCourses()){
            System.out.println(course);
        }
    }
}